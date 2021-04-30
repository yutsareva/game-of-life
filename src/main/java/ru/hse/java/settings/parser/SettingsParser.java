package ru.hse.java.settings.parser;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Set;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ru.hse.java.settings.AutomationRules;
import ru.hse.java.settings.FieldSettings;
import ru.hse.java.settings.InitialConfiguration;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.SettingsFromFile;

public class SettingsParser {

  static public Settings parse(String settingsFileName) throws InvalidSettings {
    JSONParser parser = new JSONParser();
    try {
      JSONObject settings = (JSONObject) ((JSONObject) parser
          .parse(new FileReader(settingsFileName))).get("settings");
      JSONObject fieldSettings = (JSONObject) settings.get("field");
      JSONObject initialConfiguration = (JSONObject) settings.get("initial_configuration");
      JSONObject automationRules = (JSONObject) settings.get("automation_rules");

      Duration duration = Duration
          .ofMillis(((Long) settings.get("iteration_duration_ms")).intValue());
      int iterationsCount = ((Long) settings.get("iteration_count")).intValue();
//      if (iterationsCount <= 0) {
//        throw new InvalidSettings("Invalid automation rules: iteration count must be a positive integer.");
//      }
      FieldSettings parsedFieldSettings = parseFieldSettings(fieldSettings);

      return new SettingsFromFile(
          parsedFieldSettings,
          parseAutomationRules(automationRules),
          parseInitialConfiguration(initialConfiguration, parsedFieldSettings.getHeight(), parsedFieldSettings.getWidth()),
          iterationsCount,
          duration);
    } catch (IOException | ParseException e) {
      throw new InvalidSettings("Invalid automation rules: " + e.getMessage());
    }
  }

  static private FieldSettings parseFieldSettings(JSONObject fieldSettings) {
    int height = ((Long) fieldSettings.get("height")).intValue();
    int width = ((Long) fieldSettings.get("width")).intValue();
    return new FieldSettings(height, width);
  }

  static private AutomationRules parseAutomationRules(JSONObject automationRules) {
    JSONArray aliveNeighborsToDie = (JSONArray) automationRules.get("alive_neighbors_to_die");
    Set<Integer> parsedAliveNeighborsToDie = new HashSet<>();
    for (Object elem : aliveNeighborsToDie) {
      parsedAliveNeighborsToDie.add(((Long) elem).intValue());
    }

    JSONArray aliveNeighborsToRevive = (JSONArray) automationRules.get("alive_neighbors_to_revive");
    Set<Integer> parsedAliveNeighborsToRevive = new HashSet<>();
    for (Object elem : aliveNeighborsToRevive) {
      parsedAliveNeighborsToRevive.add(((Long) elem).intValue());
    }

    Set<Integer> intersection = new HashSet<>(parsedAliveNeighborsToDie);
    intersection.retainAll(parsedAliveNeighborsToRevive);
    if (!intersection.isEmpty()) {
      throw new InvalidSettings("Invalid automation rules: duplicate cell count to die and revive.");
    }

    return new AutomationRules(parsedAliveNeighborsToRevive, parsedAliveNeighborsToDie);
  }

  static private InitialConfiguration parseInitialConfiguration(JSONObject initialConfiguration, int height, int width) {
    List<Pair<Integer, Integer>> initialAliveCells = new ArrayList<>();
    JSONArray points = (JSONArray) initialConfiguration.get("alive_points");
    for (Object o : points) {
      JSONObject point = (JSONObject) o;

      int x = ((Long) point.get("x")).intValue();
      int y = ((Long) point.get("y")).intValue();

      if (x < 0 || x >= height || y < 0 || y >= width) {
        throw new InvalidSettings("Invalid automation rules: some initial cells are out of the field: (" + x + ", " + y + ")");
      }

      Pair<Integer, Integer> curPoint = new ImmutablePair<>(x, y);
      initialAliveCells.add(curPoint);
    }
    return new InitialConfiguration(initialAliveCells);
  }
}
