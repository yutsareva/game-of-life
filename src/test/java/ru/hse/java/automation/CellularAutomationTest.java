package ru.hse.java.automation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import ru.hse.java.settings.Settings;
import ru.hse.java.settings.parser.SettingsParser;

public class CellularAutomationTest {

  @Test
  public void simple() {
    Settings settings = SettingsParser.parse("src/main/resources/examples/simple_configuration.json");
    assert settings != null;
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

    while (automation.gameFinished()) {
      field = automation.getNextIteration();
    }
    assertTrue(field.isAlive(2, 1));
    assertTrue(field.isAlive(2, 2));
    assertTrue(field.isAlive(2, 3));
  }

}
