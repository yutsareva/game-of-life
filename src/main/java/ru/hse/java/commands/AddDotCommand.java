package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.CLI;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Display;
import ru.hse.java.Runner;
import ru.hse.java.automation.CellularAutomaton;
import ru.hse.java.automation.StandardCellularAutomaton;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "add_dot" },
    commandDescription = "Add new alive cell."
)
public class AddDotCommand implements Command {

  @Parameter(
      names = "--place",
      description = "Add alive cell by coordinates.",
      required = true,
      arity = 2
  )
  private List<Integer> coordinates;

  private Settings settings;

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE);
    settings = reader.readSettings();
    if (check_flags()) {
      try {
        settings = reader.readSettings();
        settings.setIterationCount(1);
        Display display = new ConsoleDisplay();
        CellularAutomaton automation = new StandardCellularAutomaton(settings);
        display.display(automation.getNextIteration(), false, 0);
        TimeUnit.MILLISECONDS.sleep(settings.getIterationTimeInterval().toMillis());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public boolean check_flags() {
    if (coordinates.get(0) < 0 || coordinates.get(0) >= settings.getHeight() ||
        coordinates.get(1) < 0 || coordinates.get(1) >= settings.getWidth()) {
      System.out.println("Coordinates are out of board limits. Current board size is: "
          + settings.getHeight() + " " + settings.getWidth());
      return false;
    }

    List<Pair<Integer, Integer>> alive_cells = settings.getInitialAliveCells();
    for (Pair<Integer, Integer> alive_cell : alive_cells) {
      if (alive_cell.getLeft().equals(coordinates.get(0)) &&
          alive_cell.getRight().equals(coordinates.get(1))) {
        System.out.println("Cell is already alive.");
        return false;
      }
    }

    FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
    writer.writeAliveCell(
        new ImmutablePair<Integer, Integer>(coordinates.get(0), coordinates.get(1)));

    return true;
  }
}
