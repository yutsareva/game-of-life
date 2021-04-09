package ru.hse.java;

import ru.hse.java.automation.StandartCellularAutomaton;
import ru.hse.java.settings.StandartSettings;

public class Runner {
    Runner(StandartSettings settings, Display display) throws InterruptedException {
        StandartCellularAutomaton automation = new StandartCellularAutomaton(settings);
        for (int i = 0; i < settings.getIterationCount(); i++) {
            display.display(automation.getNextIteration());
            Thread.sleep(settings.getIterationTimeInterval().toMillis());
        }
    }
}
