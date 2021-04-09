package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "set_rules" },
    commandDescription = "Change rules."
)
public class SetRulesCommand implements Command {
  @Parameter(
      names = "--file",
      description = "Input file."
  )
  private String file;

  @Override
  public void run() {
    System.out.println("InitializeCommand");
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
