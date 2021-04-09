package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Display;

@Parameters(
    commandNames = { "show_start" },
    commandDescription = "Show starting board."
)
public class ShowStartCommand implements Command {
  @Override
  public void run() {
    System.out.println("ShowStartCommand");
  }

  @Override
  public boolean check_flags() {
    ConsoleDisplay display = new ConsoleDisplay();
    return true;
  }
}
