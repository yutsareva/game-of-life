package ru.hse.java.commands;

import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "show_start" },
    commandDescription = "Show starting board."
)
public class ShowStartCommand implements Command {
  @Override
  public void run() {
    System.out.println("ShowStartCommand");
  }

  @Override
  public void check_flags() {

  }
}
