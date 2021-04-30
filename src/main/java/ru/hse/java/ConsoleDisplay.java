package ru.hse.java;

import ru.hse.java.automation.Field;

public class ConsoleDisplay implements Display {
  private final String alive_cell_color;
  private final String dead_cell_color;

  public ConsoleDisplay() {
    this.alive_cell_color = "blue";
    this.dead_cell_color = "white";
  }

  public ConsoleDisplay(String alive_cell_color, String dead_cell_color) {
    this.alive_cell_color = alive_cell_color;
    this.dead_cell_color = dead_cell_color;
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  @Override
  public void display(Field field, boolean clear)  {
    if (clear) {
      clearScreen();
    }
    ConsoleColors colors = new ConsoleColors();
    String alive_color = colors.GetConsoleColor(alive_cell_color);
    String dead_color = colors.GetConsoleColor(dead_cell_color);
    String reset_color = "\033[0m";
    for (int i = 0; i < field.getHeight(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        if (field.isAlive(i, j)) {
          System.out.print(alive_color + "*" + reset_color);
        } else {
          System.out.print(dead_color + "." + reset_color);
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
