package ru.hse.java.writer;

import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.settings.AutomationRules;
import ru.hse.java.settings.Settings;

import java.time.Duration;
import java.util.List;

public abstract class Writer {
    public abstract void writeSettings(Settings settings);

    public abstract void writeHeight(Integer height);

    public abstract void writeWidth(Integer width);

    public abstract void writeIterationTimeInterval(Duration iterationTimeInterval);

    public abstract void writeAliveCell(Pair<Integer, Integer> aliveCell);

    public abstract void writeInitialAliveCells(List<Pair<Integer, Integer>> initialAliveCells);

    public abstract void writeIterationCount(int iterationCount);

    public abstract void writeAutomationRules(AutomationRules rules);
}
