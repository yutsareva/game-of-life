package ru.hse.java.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.automation.Field;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.SettingsFromFile;

public class FilesReader extends Reader {
    private final String settingsFileName;
    private final String fieldFileName;

    public FilesReader(String settingsFileName, String fieldFileName) {
        this.settingsFileName = settingsFileName;
        this.fieldFileName = fieldFileName;
    }

    @Override
    void readField() {
        System.out.println("FilesReader/@readField");
    }

    @Override
    public SettingsFromFile readSettings() {
        List<Pair<Integer, Integer>> initialAliveCells = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader(this.settingsFileName));
            JSONObject base_params = (JSONObject) a.get(0);
            int height = ((Long) base_params.get("height")).intValue();
            int width = ((Long) base_params.get("width")).intValue();
            Duration duration = Duration.ofMillis(((Long) base_params.get("duration")).intValue());
            int iterationsCount = ((Long) base_params.get("iterationsCount")).intValue();
            JSONObject points_obj = (JSONObject) a.get(1);
            JSONArray points = (JSONArray) points_obj.get("points");
            for (Object o : points)
            {
                JSONObject point = (JSONObject) o;

                Integer x = ((Long) point.get("x")).intValue();
                Integer y = ((Long) point.get("y")).intValue();

                Pair<Integer, Integer> curPoint = new ImmutablePair<>(x, y );
                initialAliveCells.add(curPoint);
            }
            SettingsFromFile settings = new SettingsFromFile(height,
                    width,
                    iterationsCount,
                    duration,
                    this.settingsFileName,
                    initialAliveCells);
            return settings;
        } catch (IOException | ParseException e) {
            System.out.println("in reader catch");
            e.printStackTrace();
            return null;
        }
    }
}
