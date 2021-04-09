package ru.hse.java.settings;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SettingsFromFile extends Settings {
    final private int fieldHeight;
    final private int fieldWeight;
    final private int iterationCount;
    final private Duration iterationTimeInterval;
    final private String fileName;
    public List<Pair<Integer, Integer>> initialAliveCells;

    public SettingsFromFile(int fieldHeight,
                            int fieldWeight,
                            int iterationCount,
                            Duration iterationTimeInterval,
                            String fileName,
                            List<Pair<Integer, Integer>> initialAliveCells) {
        this.fieldHeight = fieldHeight;
        this.fieldWeight = fieldWeight;
        this.iterationCount = iterationCount;
        this.iterationTimeInterval = iterationTimeInterval;
        this.fileName = fileName;
        this.initialAliveCells = initialAliveCells;
    }

    @Override
    public Integer getHeight() {
        return fieldHeight;
    }

    @Override
    public Integer getWidth() {
        return fieldWeight;
    }

    @Override
    public Duration getIterationTimeInterval() {
        return iterationTimeInterval;
    }

    @Override
    public List<Pair<Integer, Integer>> getInitialAliveCells() {
        return initialAliveCells;
    }

    @Override
    public int getIterationCount() {
        return iterationCount;
    }
}
