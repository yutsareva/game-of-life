package ru.hse.java.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.parser.SettingsParser;

public class CellularAutomationTest {

  @Test
  public void first() {
    Settings settings = SettingsParser.parse("src/main/resources/test_data/simple_configuration.json");
    CellularAutomaton automation = new StandardCellularAutomaton(settings);
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

    while (!automation.gameFinished()) {
      field = automation.getNextIteration();
    }
    assertTrue(field.isAlive(2, 1));
    assertTrue(field.isAlive(2, 2));
    assertTrue(field.isAlive(2, 3));
  }

  @Test
  public void second() {
    Settings settings = SettingsParser.parse("src/main/resources/test_data/test_stable_configuration.json");
    CellularAutomaton automation = new StandardCellularAutomaton(settings);
    assertFalse(automation.gameFinished());

    var field = automation.getNextIteration();
    assertTrue(field.isAlive(0, 0));
    assertFalse(field.isAlive(0, 1));
    assertFalse(field.isAlive(0, 2));
    assertFalse(field.isAlive(1, 0));
    assertTrue(field.isAlive(1, 1));
    assertFalse(field.isAlive(1, 2));
    assertFalse(field.isAlive(2, 0));
    assertFalse(field.isAlive(2, 1));
    assertTrue(field.isAlive(2, 2));

    int iterationPassed = 1;

    while (!automation.gameFinished()) {
      ++iterationPassed;
      field = automation.getNextIteration();
    }
    assertEquals(iterationPassed, 6);

    assertFalse(field.isAlive(0, 0));
    assertFalse(field.isAlive(0, 1));
    assertFalse(field.isAlive(0, 2));
    assertFalse(field.isAlive(1, 0));
    assertFalse(field.isAlive(1, 1));
    assertFalse(field.isAlive(1, 2));
    assertFalse(field.isAlive(2, 0));
    assertFalse(field.isAlive(2, 1));
    assertFalse(field.isAlive(2, 2));
  }

}
