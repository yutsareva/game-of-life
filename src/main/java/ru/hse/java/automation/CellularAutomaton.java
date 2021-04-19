package ru.hse.java.automation;


public abstract class CellularAutomaton {

  public abstract Field getNextIteration();

  public abstract boolean gameFinished();
}
