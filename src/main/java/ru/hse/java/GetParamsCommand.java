package ru.hse.java;

import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "get_params" },
    commandDescription = "Print current parameters of the simulation."
)
public class GetParamsCommand implements Command {
  @Override
  public void run() {
    System.out.println("GetParamsCommand");
  }
}