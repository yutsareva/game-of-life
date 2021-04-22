package ru.hse.java.writer;

import org.apache.commons.lang3.tuple.Pair;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.AutomationRules;
import ru.hse.java.settings.FieldSettings;
import ru.hse.java.settings.Settings;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;

public class FilesWriter extends Writer {
    private final String settingsFileName;

    public FilesWriter(String settingsFileName) {
        this.settingsFileName = settingsFileName;
    }

    @Override
    public void writeSettings(Settings settings) {  //TODO O(n^2) -> O(n)
        writeHeight(settings.getHeight());
        writeWidth(settings.getWidth());
        writeIterationTimeInterval(settings.getIterationTimeInterval());
        writeInitialAliveCells(settings.getInitialAliveCells());
        writeIterationCount(settings.getIterationCount());
        writeAutomationRules(settings.getAutomationRules());
    }

    @Override
    public void writeHeight(Integer height) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");
            JSONObject fieldSettings = (JSONObject) settings.get("field");

            fieldSettings.put("height", height);

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeHeight catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeWidth(Integer width) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");
            JSONObject fieldSettings = (JSONObject) settings.get("field");

            fieldSettings.put("width", width);

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeWidth catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeIterationTimeInterval(Duration iterationTimeInterval) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");

            settings.put("iteration_duration_ms", iterationTimeInterval.toMillis());

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeIterationTimeInterval catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeAliveCell(Pair<Integer, Integer> aliveCell) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");
            JSONObject initial_configuration = (JSONObject) settings.get("initial_configuration");
            JSONArray alive_points = (JSONArray) initial_configuration.get("alive_points");

            JSONObject cell = new JSONObject();
            cell.put("x", aliveCell.getKey());
            cell.put("y", aliveCell.getValue());
            alive_points.add(cell);

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeIterationTimeInterval catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeInitialAliveCells(List<Pair<Integer, Integer>> initialAliveCells) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");
            JSONObject initial_configuration = (JSONObject) settings.get("initial_configuration");
            JSONArray alive_points = (JSONArray) initial_configuration.get("alive_points");

            alive_points.clear();

            for (Pair<Integer, Integer> aliveCell : initialAliveCells) {
                JSONObject cell_object = new JSONObject();
                cell_object.put("x", aliveCell.getKey());
                cell_object.put("y", aliveCell.getValue());
                alive_points.add(cell_object);
            }

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeIterationTimeInterval catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeIterationCount(int iterationCount) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");

            settings.put("iteration_count", iterationCount);

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeIterationTimeInterval catch");
            e.printStackTrace();
        }
    }

    @Override
    public void writeAutomationRules(AutomationRules rules) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject main = (JSONObject) parser.parse(new FileReader(settingsFileName));
            JSONObject settings = (JSONObject) main.get("settings");
            JSONObject automation_rules = (JSONObject) settings.get("automation_rules");

            automation_rules.put("alive_neighbors_to_revive", rules.getAliveNeighborsToRevive());
            automation_rules.put("alive_neighbors_to_die", rules.getAliveNeighborsToDie());

            FileWriter writer = new FileWriter(settingsFileName);
            main.writeJSONString(writer);
            writer.flush();
            writer.close();
        } catch (IOException | ParseException e) {
            System.out.println("in writeIterationTimeInterval catch");
            e.printStackTrace();
        }
    }
}