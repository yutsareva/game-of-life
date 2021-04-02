package ru.hse.java;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;

@Parameters(
    commandNames = { "add_figure" },
    commandDescription = "Add new figure."
)
public class AddFigureCommand implements Command {
  @Parameter(
      names = "--place",
      description = "Add alive cells figure by coordinates of top left corner."
  )
  private List<Integer> coordinates;

  @Parameter(
      names = "--type",
      description = "Figure type."
  )
  private String type;

  @Override
  public void run() {
    System.out.println("AddFigureCommand");
  }
}
