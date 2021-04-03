package ru.hse.java.automation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Field {
  private final List<BitSet> matrix;
  private int height;
  private int width;
  Field(int fieldHeight, int fieldWidth) {
    this.height = fieldHeight;
    this.width = fieldWidth;

    matrix = new ArrayList<>(fieldHeight);
    for (int i = 0; i < fieldHeight; i++) {
      matrix.add(i, new BitSet(width));
    }
  }

  public boolean isAlive(int x, int y) {
    return matrix.get(x).get(y);
  }

  public void  killCell(int x, int y) {
    matrix.get(x).set(y, false);
  }

  public void  reviveCell(int x, int y) {
    matrix.get(x).set(y, true);
  }

  public int getAliveNeighbourCount(int x, int y) {
    int count = 0;
    if (x > 0) {
      count += isAlive(x - 1, y) ? 1 : 0;
    }
    if (y > 0) {
      count += isAlive(x, y - 1) ? 1 : 0;
    }
    if (x > 0 && y > 0) {
      count += isAlive(x - 1, y - 1) ? 1 : 0;
    }
    if (x < height - 1) {
      count += isAlive(x + 1, y) ? 1 : 0;
    }
    if (y < width - 1) {
      count += isAlive(x, y + 1) ? 1 : 0;
    }
    if (x < height - 1 && y < width - 1) {
      count += isAlive(x, y + 1) ? 1 : 0;
    }
    if (x > 0 && y < width - 1) {
      count += isAlive(x - 1, y + 1) ? 1 : 0;
    }
    if (x < height - 1 && y > 0) {
      count += isAlive(x + 1, y - 1) ? 1 : 0;
    }
    return count;
  }

  public int  getHeight() {
    return height;
  }

  public int  getWidth() {
    return width;
  }
}
