package ru.hse.java;

import ru.hse.java.automation.Field;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileDisplay implements Display {
  private final String displayFileName;

  FileDisplay(String displayFileName) {
    this.displayFileName = displayFileName;
  }

  @Override
  public void display(Field field, boolean clear, int iteration) {
    try {
      Files.write(Paths.get(displayFileName), String.valueOf(iteration).getBytes(), StandardOpenOption.APPEND);
      Files.write(Paths.get(displayFileName), "\n".getBytes(), StandardOpenOption.APPEND);
      for (int i = 0; i < field.getHeight(); i++) {
        for (int j = 0; j < field.getWidth(); j++) {
          if (field.isAlive(i, j)) {
            Files.write(Paths.get(displayFileName), "*".getBytes(), StandardOpenOption.APPEND);
          } else {
            Files.write(Paths.get(displayFileName), ".".getBytes(), StandardOpenOption.APPEND);
          }
        }
        Files.write(Paths.get(displayFileName), "\n".getBytes(), StandardOpenOption.APPEND);
      }
      Files.write(Paths.get(displayFileName), "\n\n".getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("File error.");
      e.printStackTrace();
    }
  }
}
