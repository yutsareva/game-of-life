package ru.hse.java;

public interface CellularAutomaton {
  void updateFieldConfiguration(Field field);
  boolean gameFinished(Field field);
}
