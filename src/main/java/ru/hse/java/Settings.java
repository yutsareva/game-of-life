package ru.hse.java;

import java.util.List;

public interface Settings {
  List<Integer> getFieldSize();
  String getAliveCellColor();
  double getIterationTimeInterval();
}
