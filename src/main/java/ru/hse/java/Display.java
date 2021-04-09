package ru.hse.java;

import ru.hse.java.automation.Field;

public interface Display {
  default void display(Field field) {
  };
}
