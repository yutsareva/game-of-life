package ru.hse.java.automation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.StandartSettings;

public class StandartCellularAutomationTest {
  @Test
  public void create() {
    Settings settings = new StandartSettings();
    CellularAutomaton automation = new StandartCellularAutomaton(settings);
    assertFalse(automation.gameFinished());

    var field = automation.getNextIteration();
    assertTrue(field.isAlive(1, 2));
    assertTrue(field.isAlive(2, 2));
    assertTrue(field.isAlive(3, 2));

    field = automation.getNextIteration();
    assertFalse(field.isAlive(1, 2));
    assertTrue(field.isAlive(2, 2));
    assertFalse(field.isAlive(3, 2));
    assertTrue(field.isAlive(2, 1));
    assertTrue(field.isAlive(2, 3));

    while (automation.gameFinished()) {
      field = automation.getNextIteration();
    }
    assertTrue(field.isAlive(2, 1));
    assertTrue(field.isAlive(2, 2));
    assertTrue(field.isAlive(2, 3));
  }

}
