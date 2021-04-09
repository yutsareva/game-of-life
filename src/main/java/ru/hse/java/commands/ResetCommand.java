package ru.hse.java.commands;

import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "reset" },
    commandDescription = "Reset simulation parameters to default values."
)
public class ResetCommand implements Command {
  @Override
  public void run() {
    System.out.println("ResetCommand");
  }

  @Override
  public boolean check_flags() { return true; }
}
