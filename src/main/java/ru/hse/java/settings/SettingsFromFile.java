package ru.hse.java.settings;

import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.util.List;

public class SettingsFromFile extends Settings {
    private int fieldHeight;
    private int fieldWidth;
    private int iterationCount;
    private Duration iterationTimeInterval;
    final private String fileName;
    public List<Pair<Integer, Integer>> initialAliveCells;

    public SettingsFromFile(int fieldHeight,
                            int fieldWidth,
                            int iterationCount,
                            Duration iterationTimeInterval,
                            String fileName,
                            List<Pair<Integer, Integer>> initialAliveCells) {
        this.fieldHeight = fieldHeight;
        this.fieldWidth = fieldWidth;
        this.iterationCount = iterationCount;
        this.iterationTimeInterval = iterationTimeInterval;
        this.fileName = fileName;
        this.initialAliveCells = initialAliveCells;
    }

    @Override
    public Integer getHeight() {
        return fieldHeight;
    }

    public void setHeight(Integer height) {
        fieldHeight = height;
    }

    @Override
    public Integer getWidth() {
        return fieldWidth;
    }

    public void setWidth(Integer width) {
        fieldWidth = width;
    }

    @Override
    public Duration getIterationTimeInterval() {
        return iterationTimeInterval;
    }

    public void setIterationTimeInterval(Duration iterationTimeInterval) {
        this.iterationTimeInterval = iterationTimeInterval;
    }

    @Override
    public List<Pair<Integer, Integer>> getInitialAliveCells() {
        return initialAliveCells;
    }

    @Override
    public int getIterationCount() {
        return iterationCount;
    }

    public void setIterationCount(int iterationCount) {
        this.iterationCount = iterationCount;
    }
}
