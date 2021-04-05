package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;

@Parameters(
    commandNames = { "remove_dot" },
    commandDescription = "Remove alive cell simulation."
)
public class RemoveDotCommand implements Command {
  @Parameter(
      names = "--place",
      description = "Remove alive cell by coordinates."
  )
  private List<Integer> coordinates;

  @Override
  public void run() {
    System.out.println("RemoveDotCommand");
  }
}
