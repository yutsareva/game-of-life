package ru.hse.java.commands;

import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "help" },
    commandDescription = ""
)
public class HelpCommand implements Command {
  @Override
  public void run() {}

  @Override
  public void check_flags() {}
}
