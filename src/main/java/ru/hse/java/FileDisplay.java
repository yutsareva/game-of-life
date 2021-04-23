package ru.hse.java;

import ru.hse.java.automation.Field;
import java.io.IOException;
import java.io.FileWriter;

public class FileDisplay implements Display {

  @Override
  public void display(Field field, boolean clear) {
    try {
      FileWriter file = new FileWriter("output.txt");
      for (int i = 0; i < field.getHeight(); i++) {
        for (int j = 0; j < field.getWidth(); j++) {
          if (field.isAlive(i, j)) {
            file.write("*");
          } else {
            file.write(".");
          }
          file.write("\n");
        }
      }
    } catch (IOException e) {
      System.out.println("File error.");
      e.printStackTrace();
    }
  }
}
