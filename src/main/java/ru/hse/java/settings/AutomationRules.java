package ru.hse.java.settings;

import java.util.List;

public class AutomationRules {

  private List<Integer> aliveNeighborsToRevive;
  private List<Integer> aliveNeighborsToDie;
  // maxIterationCountToLive - ?

  public AutomationRules(List<Integer> aliveNeighborsToRevive, List<Integer> aliveNeighborsToDie) {
    this.aliveNeighborsToDie = aliveNeighborsToDie;
    this.aliveNeighborsToRevive = aliveNeighborsToRevive;
  }
}
