package ru.hse.java.writer;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import ru.hse.java.settings.AutomationRules;

import java.time.Duration;
import java.util.*;

import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.parser.SettingsParser;

import static org.junit.Assert.*;

public class FilesWriterTest {
    public final String path = "src/main/resources/examples/test_configuration.json";

    @Test
    public void writeHeightTest() {
        Settings previous_settings = SettingsParser.parse(path);
        assert previous_settings != null;
        Integer previous_height = previous_settings.getHeight();

        Integer new_height = 33;
        FilesWriter curWriter = new FilesWriter(path);
        curWriter.writeHeight(new_height);

        Settings current_settings = SettingsParser.parse(path);
        assert current_settings != null;
        assertEquals(new_height, current_settings.getHeight());

        curWriter.writeHeight(previous_height);
        Settings new_settings = SettingsParser.parse(path);
        assert new_settings != null;
        assertSame(previous_height, new_settings.getHeight());
    }

    @Test
    public void writeIterationTimeInterval() {
        FilesWriter curWriter = new FilesWriter(path);
        curWriter.writeIterationTimeInterval(Duration.ofMillis(250L));
    }

    @Test
    public void writeIterationCount() {
        FilesWriter curWriter = new FilesWriter(path);
        curWriter.writeIterationCount(20);
    }

    @Test
    public void writeAutomationRules() {
        FilesWriter curWriter = new FilesWriter(path);
        Set<Integer> alive_neighbors_to_revive = new HashSet<Integer>(Arrays.asList(2, 8));
        Set<Integer> alive_neighbors_to_die = new HashSet<Integer>(Arrays.asList(0, 4, 5, 6, 7));
        AutomationRules rules = new AutomationRules(alive_neighbors_to_revive, alive_neighbors_to_die);
        curWriter.writeAutomationRules(rules);
    }

    @Test
    public void writeInitialAliveCells() {
        FilesWriter curWriter = new FilesWriter(path);
        List<Pair<Integer, Integer>> initialAliveCells = new ArrayList<>();
        initialAliveCells.add(new ImmutablePair<Integer, Integer>(1, 1));
        initialAliveCells.add(new ImmutablePair<Integer, Integer>(2, 2));
        initialAliveCells.add(new ImmutablePair<Integer, Integer>(3, 3));
        initialAliveCells.add(new ImmutablePair<Integer, Integer>(4, 4));
        curWriter.writeInitialAliveCells(initialAliveCells);
    }

    @Test
    public void writeAliveCell() {
        FilesWriter curWriter = new FilesWriter(path);
        Pair<Integer, Integer> aliveCell = new ImmutablePair<Integer, Integer>(1, 1);
        curWriter.writeAliveCell(aliveCell);
    }
}
