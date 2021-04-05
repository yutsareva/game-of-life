package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;

@Parameters(
    commandNames = { "add_dot" },
    commandDescription = "Add new alive cell."
)
public class AddDotCommand implements Command {
  @Parameter(
      names = "--place",
      description = "Add alive cell by coordinates."
  )
  private List<Integer> coordinates;

  @Override
  public void run() {
    System.out.println("AddDotCommand");
  }
}
