package ru.hse.java.commands;

public interface Command {
  void run();
  boolean check_flags();
}
