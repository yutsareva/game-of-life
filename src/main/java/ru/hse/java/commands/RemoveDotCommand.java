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
      description = "Remove alive cell by coordinates.",
      required = true
  )
  private List<Integer> coordinates;

  @Override
  public void run() {
    System.out.println("RemoveDotCommand");
  }

  @Override
  public boolean check_flags() {
    if (coordinates.size() != 2) {
      System.out.println("'--place' should be an array of size 2.");
      return false;
    }
    // Change after Reader is implemented.
//    var boardSize = Reader().Read(CLI.CURRENT_PARAMETERS_FILE).getSize();
//    if (coordinates.get(0) < 0 || coordinates.get(1) >= boardSize.get(0) ||
//        coordinates.get(1) < 0 || coordinates.get(1) >= boardSize.get(1)) {
//      System.out.println("Coordinates are out of board limits. Current board size is: ");
//      return;
//    }

    // Check if cell is actually alive and remove it from the board if it is.
    return true;
  }
}
