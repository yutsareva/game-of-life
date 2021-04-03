package ru.hse.java.settings;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public abstract class Settings {

  public abstract Integer getHeight();

  public abstract Integer getWidth();

  public abstract Duration getIterationTimeInterval();

  public abstract List<Pair<Integer, Integer>> getInitialAliveCells();

  public abstract int getIterationCount();
//  String getAliveCellColor();
}
