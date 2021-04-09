package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(
    commandNames = { "show_board" },
    commandDescription = "Show given board."
)
public class ShowBoardCommand implements Command {
  @Parameter(
      names = "--file",
      description = "Input file.",
      required = true
  )
  private String file;
  
  @Override
  public void run() {
    System.out.println("ShowBoardCommand");
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
