package ru.hse.java;

import ru.hse.java.automation.Field;

public interface Display {

  default void display(Field field, boolean clear, String alive_cell_color = 'black', String dead_cell_color = 'black') {
  }
}
