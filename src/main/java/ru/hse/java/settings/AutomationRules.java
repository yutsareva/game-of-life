package ru.hse.java.settings;

import java.util.Set;

public class AutomationRules {

  private Set<Integer> aliveNeighborsToRevive;
  private Set<Integer> aliveNeighborsToDie;
  // maxIterationCountToLive - ?

  public AutomationRules(Set<Integer> aliveNeighborsToRevive, Set<Integer> aliveNeighborsToDie) {
    this.aliveNeighborsToDie = aliveNeighborsToDie;
    this.aliveNeighborsToRevive = aliveNeighborsToRevive;
  }

  public Set<Integer> getAliveNeighborsToRevive() {
    return aliveNeighborsToRevive;
  }

  public Set<Integer> getAliveNeighborsToDie() {
    return aliveNeighborsToDie;
  }

}
