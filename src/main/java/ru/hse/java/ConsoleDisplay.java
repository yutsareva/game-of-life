package ru.hse.java;

import ru.hse.java.automation.Field;

public class ConsoleDisplay implements Display {

  @Override
  public void display(Field field) {
    for (int i = 0; i < field.getHeight(); i++) {
      for (int j = 0; j < field.getWidth(); j++) {
        if (field.isAlive(i, j)) {
          System.out.print(".");
        } else {
          System.out.print("*");
        }
        System.out.println();
      }
    }
  }
}
