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

  static public Settings parse(String settingsFileName) {
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

      return new SettingsFromFile(
          parseFieldSettings(fieldSettings),
          parseAutomationRules(automationRules),
          parseInitialConfiguration(initialConfiguration),
          iterationsCount,
          duration);
    } catch (IOException | ParseException e) {
      System.out.println("in reader catch");
      e.printStackTrace();
      return null;
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

    Set<Integer> intersection = new HashSet<Integer>(parsedAliveNeighborsToDie);
    intersection.retainAll(parsedAliveNeighborsToRevive);
    if (!intersection.isEmpty()) {
      throw new InvalidSettings("Invalid automation rules.");
    }

    return new AutomationRules(parsedAliveNeighborsToRevive, parsedAliveNeighborsToDie);
  }

  static private InitialConfiguration parseInitialConfiguration(JSONObject initialConfiguration) {
    List<Pair<Integer, Integer>> initialAliveCells = new ArrayList<>();
    JSONArray points = (JSONArray) initialConfiguration.get("alive_points");
    for (Object o : points) {
      JSONObject point = (JSONObject) o;

      Integer x = ((Long) point.get("x")).intValue();
      Integer y = ((Long) point.get("y")).intValue();

      Pair<Integer, Integer> curPoint = new ImmutablePair<>(x, y);
      initialAliveCells.add(curPoint);
    }
    return new InitialConfiguration(initialAliveCells);
  }
}
