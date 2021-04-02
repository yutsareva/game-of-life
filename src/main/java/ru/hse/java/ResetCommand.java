package ru.hse.java;

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
}
