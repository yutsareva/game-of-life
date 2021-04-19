package ru.hse.java.settings;

import java.util.List;
import org.apache.commons.lang3.tuple.Pair;

public class InitialConfiguration {

  private List<Pair<Integer, Integer>> initialAliveCells;

  public InitialConfiguration(List<Pair<Integer, Integer>> initialAliveCells) {
    this.initialAliveCells = initialAliveCells;
  }

  public List<Pair<Integer, Integer>> getInitialAliveCells() {
    return initialAliveCells;
  }
}
