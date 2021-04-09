package ru.hse.java;

import ru.hse.java.automation.StandartCellularAutomaton;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.SettingsFromFile;
import ru.hse.java.settings.StandartSettings;
import java.util.concurrent.TimeUnit;

public class Runner {
    private final Settings settings;
    private final Display display;

    public Runner(Settings settings, Display display) {
        this.settings = settings;
        this.display = display;
    }

    public void run() throws InterruptedException {
        StandartCellularAutomaton automation = new StandartCellularAutomaton(settings);
        for (int i = 0; i < settings.getIterationCount() || settings.getIterationCount() < 0; i++) {
            display.display(automation.getNextIteration());
            TimeUnit.MILLISECONDS.sleep(settings.getIterationTimeInterval().toMillis());
        }
    }
}
