package ru.hse.java.settings;

public class FieldSettings {

  private int height;
  private int width;
  // cellSize - ?
  // aliveCellSymbol - ?
  // deadCellSymbol - ?

  public FieldSettings(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public void setWidth(int width) {
    this.width = width;
  }
}
