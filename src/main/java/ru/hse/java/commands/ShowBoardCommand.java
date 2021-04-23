package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.concurrent.TimeUnit;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Display;
import ru.hse.java.Runner;
import ru.hse.java.automation.CellularAutomaton;
import ru.hse.java.automation.StandardCellularAutomaton;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

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
    FilesReader reader = new FilesReader(file);
    try {
      Settings settings = reader.readSettings();
      settings.setIterationCount(1);
      Display display = new ConsoleDisplay();
      CellularAutomaton automation = new StandardCellularAutomaton(settings);
      display.display(automation.getNextIteration(), false);
      TimeUnit.MILLISECONDS.sleep(settings.getIterationTimeInterval().toMillis());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
