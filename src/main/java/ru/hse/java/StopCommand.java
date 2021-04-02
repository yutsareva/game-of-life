package ru.hse.java;

import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "stop" },
    commandDescription = "Terminates simulation."
)
public class StopCommand implements Command {

  @Override
  public void run() {
    System.out.println("StopCommand");
  }
}