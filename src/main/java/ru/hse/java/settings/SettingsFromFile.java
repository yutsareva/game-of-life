package ru.hse.java.settings;

import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.util.List;

public class SettingsFromFile extends Settings {

  private final AutomationRules automationRules;
  private final FieldSettings fieldSettings;

  private int iterationCount;
  private Duration iterationTimeInterval;

  private final InitialConfiguration initialConfiguration;

  public SettingsFromFile(
      FieldSettings fieldSettings,
      AutomationRules automationRules,
      InitialConfiguration initialConfiguration,
      int iterationCount,
      Duration iterationTimeInterval) {
    this.fieldSettings = fieldSettings;
    this.automationRules = automationRules;
    this.iterationCount = iterationCount;
    this.iterationTimeInterval = iterationTimeInterval;
    this.initialConfiguration = initialConfiguration;
  }

  @Override
  public Integer getHeight() {
    return fieldSettings.getHeight();
  }

  @Override
  public Integer getWidth() {
    return fieldSettings.getWidth();
  }

  @Override
  public Duration getIterationTimeInterval() {
    return iterationTimeInterval;
  }

  @Override
  public List<Pair<Integer, Integer>> getInitialAliveCells() {
    return initialConfiguration.getInitialAliveCells();
  }

  @Override
  public int getIterationCount() {
    return iterationCount;
  }

  @Override
  public AutomationRules getAutomationRules() {
    return automationRules;
  }

  @Override
  public void setIterationCount(int iterationCount) {
    this.iterationCount = iterationCount;
  }

  @Override
  public void setIterationTimeInterval(Duration iterationTimeInterval) {
    this.iterationTimeInterval = iterationTimeInterval;
  }

  @Override
  public void setWidth(Integer width) {
    fieldSettings.setWidth(width);
  }

  @Override
  public void setHeight(Integer height) {
    fieldSettings.setHeight(height);
  }
}
