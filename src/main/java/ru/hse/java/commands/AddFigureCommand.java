package ru.hse.java.commands;

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
      description = "Add alive cells figure by coordinates of top left corner.",
      required = true
  )
  private List<Integer> coordinates;

  @Parameter(
      names = "--type",
      description = "Figure type.",
      required = true
  )
  private String type;

  @Override
  public void run() {
    System.out.println("AddFigureCommand");
  }

  @Override
  public boolean check_flags() {
    if (coordinates.size() != 2) {
      System.out.println("'--place' should be an array of size 2.");
      return false;
    }

    // Implement later I guess...

    return true;
  }
}
