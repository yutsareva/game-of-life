package ru.hse.java.automation;


public abstract class CellularAutomaton {

  public abstract Field getNextIteration();

  public abstract boolean gameFinished();

  public abstract void setIterationsLeft(int new_iterations_left);
}
