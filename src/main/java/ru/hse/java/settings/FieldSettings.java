package ru.hse.java.settings;

public class FieldSettings {

  private int height;
  private int width;
  private String color_alive;
  private String color_dead;
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

  public String getColorAlive() {
    return color_alive;
  }

  public String getColorDead() {
    return color_dead;
  }

  public void setColorAlive(String color) {
     this.color_alive = color;
  }

  public void setColorDead(String color) {
    this.color_dead = color;
  }
}
