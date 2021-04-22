package ru.hse.java.writer;

import org.apache.commons.lang3.tuple.Pair;
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
    public void writeSettings(Settings settings) {
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

    }

    @Override
    public void writeInitialAliveCells(List<Pair<Integer, Integer>> initialAliveCells) {

    }

    @Override
    public void writeIterationCount(int iterationCount) {

    }

    @Override
    public void writeAutomationRules(AutomationRules rules) {

    }
}