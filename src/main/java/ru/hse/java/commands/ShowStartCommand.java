package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import java.util.concurrent.TimeUnit;
import ru.hse.java.CLI;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Display;
import ru.hse.java.Runner;
import ru.hse.java.automation.CellularAutomaton;
import ru.hse.java.automation.StandardCellularAutomaton;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

@Parameters(
    commandNames = { "show_start" },
    commandDescription = "Show starting board."
)
public class ShowStartCommand implements Command {

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE);
    try {
      Settings settings = reader.readSettings();
      settings.setIterationCount(1);
      Display display = new ConsoleDisplay();
      CellularAutomaton automation = new StandardCellularAutomaton(settings);
      display.display(automation.getNextIteration(), false, 0);
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
