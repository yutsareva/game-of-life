package ru.hse.java.settings;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public abstract class Settings {

  public abstract Integer getHeight();

  public abstract Integer getWidth();

  public abstract String getColorAlive();

  public abstract String getColorDead();

  public abstract Duration getIterationTimeInterval();

  public abstract List<Pair<Integer, Integer>> getInitialAliveCells();

  public abstract int getIterationCount();

  public abstract AutomationRules getAutomationRules();

  public abstract void setIterationCount(int iterationCount);

  public abstract void setIterationTimeInterval(Duration iterationTimeInterval);

  public abstract void setHeight(Integer height);

  public abstract void setWidth(Integer width);

  public abstract void setColorAlive(String color);

  public abstract void setColorDead(String color);

}
