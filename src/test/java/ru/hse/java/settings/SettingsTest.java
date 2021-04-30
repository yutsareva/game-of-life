package ru.hse.java.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.Duration;
import org.junit.Test;
import ru.hse.java.settings.parser.SettingsParser;

public class SettingsTest {

  @Test
  public void simple() {
    var settings = SettingsParser
        .parse("src/main/resources/test_data/simple_configuration.json");
    assertEquals(10, settings.getIterationCount());
    assertEquals(Duration.ofMillis(300), settings.getIterationTimeInterval());
    assertEquals(Integer.valueOf(5), settings.getHeight());
    assertEquals(Integer.valueOf(5), settings.getWidth());
    assertNull(settings.getColorAlive());
    assertNull(settings.getColorDead());

    var initialAliveCells = settings.getInitialAliveCells();
    assertEquals(initialAliveCells.size(), 3);

    var automationRules = settings.getAutomationRules();
    var aliveNeighborsToRevive = automationRules.getAliveNeighborsToRevive();
    var aliveNeighborsToDie = automationRules.getAliveNeighborsToDie();
    assertEquals(1, aliveNeighborsToRevive.size());
    assertEquals(7, aliveNeighborsToDie.size());

  }


  @Test
  public void set_new_settings() {
    var settings = SettingsParser
        .parse("src/main/resources/test_data/simple_configuration.json");
    settings.setIterationCount(50);
    assertEquals(50, settings.getIterationCount());

    settings.setIterationTimeInterval(Duration.ofMillis(100));
    assertEquals(Duration.ofMillis(100), settings.getIterationTimeInterval());

    settings.setHeight(10);
    assertEquals(Integer.valueOf(10), settings.getHeight());

    settings.setWidth(20);
    assertEquals(Integer.valueOf(20), settings.getWidth());

    settings.setColorAlive("blue");
    assertEquals("blue", settings.getColorAlive());

    settings.setColorDead("red");
    assertEquals("red", settings.getColorDead());
  }
}
