package ru.hse.java;

import ru.hse.java.automation.Field;

public class ConsoleDisplay implements Display {

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  @Override
  public void display(Field field) {
    clearScreen();
    for (int i = 0; i < field.getHeight(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        if (field.isAlive(i, j)) {
          System.out.print("*");
        } else {
          System.out.print(".");
        }
      }
      System.out.println();
    }
    System.out.println();
  }
}
