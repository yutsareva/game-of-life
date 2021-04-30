package ru.hse.java;

import org.checkerframework.framework.qual.Unused;
import ru.hse.java.automation.Field;

public class ConsoleDisplay implements Display {
  private String alive_cell_color = "blue";
  private String dead_cell_color = "white";

  public ConsoleDisplay() {
  }

  public ConsoleDisplay(String alive_cell_color, String dead_cell_color) {
    if (alive_cell_color != null) {
      this.alive_cell_color = alive_cell_color;
    }
    if (dead_cell_color != null) {
      this.dead_cell_color = dead_cell_color;
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  @Override
  public void display(Field field, boolean clear, int iteration)  {
    if (clear && iteration < 100500) {
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
