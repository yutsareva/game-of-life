package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;
import ru.hse.java.CLI;

@Parameters(
    commandNames = { "add_dot" },
    commandDescription = "Add new alive cell."
)
public class AddDotCommand implements Command {
  @Parameter(
      names = "--place",
      description = "Add alive cell by coordinates.",
      required = true
  )
  private List<Integer> coordinates;

  @Override
  public void run() {
    System.out.println("AddDotCommand");
  }

  @Override
  public void check_flags() {
    if (coordinates.size() != 2) {
      System.out.println("'--place' should be an array of size 2.");
      return;
    }
    // Change after Reader is implemented.
//    var boardSize = Reader().Read(CLI.CURRENT_PARAMETERS_FILE).getSize();
//    if (coordinates.get(0) < 0 || coordinates.get(1) >= boardSize.get(0) ||
//        coordinates.get(1) < 0 || coordinates.get(1) >= boardSize.get(1)) {
//      System.out.println("Coordinates are out of board limits. Current board size is: ");
//      return;
//    }

    // Check if cell is already alive and add if to the board if it's not.
  }
}
