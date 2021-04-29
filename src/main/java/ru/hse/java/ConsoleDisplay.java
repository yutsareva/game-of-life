package ru.hse.java;

import ru.hse.java.automation.Field;

public class ConsoleDisplay implements Display {

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  @Override
  public void display(Field field, boolean clear, String alive_cell_color, String dead_cell_color)  {
    if (clear) {
      clearScreen();
    }
    String alive_color = new String(ConsoleColors(alive_cell_color));
    String dead_color = new String(ConsoleColors(dead_cell_color));
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
