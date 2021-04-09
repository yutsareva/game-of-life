package ru.hse.java.commands;

public interface Command {
  void run();
  void check_flags();
}
