package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.time.Duration;
import ru.hse.java.CLI;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Runner;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

import java.util.List;

@Parameters(
    commandNames = { "run" },
    commandDescription = "Run simulation."
)
public class RunCommand implements Command {

  @Parameter(
      names = "--speed",
      description = "Simulation speed in ms."
  )
  private int speed;

  @Parameter(
      names = "--size",
      description = "Board size.",
      arity = 2
  )
  private List<Integer> size;

  @Parameter(
      names = "--iters_count",
      description = "Number of iterations to simulate."
  )
  private int iters_count;

  @Parameter(
      names = "--snapshot",
      description = "Boolean flag for saving intermediate board states"
  )
  private boolean snapshot = false;

  @Parameter(
      names = "--snapshot_step",
      description = "Snapshot frequency."
  )
  private int snapshot_step;

  @Parameter(
      names = "--snapshot_file",
      description = "File to save snapshots."
  )
  private double snapshot_file;

  @Parameter(
      names = "--color",
      description = "Color of alive cells."
  )
  private double color;

  private Settings settings;

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE, "");
    settings = reader.readSettings();
    if (check_flags()) {
      Runner runner = new Runner(settings, new ConsoleDisplay());
      try {
        runner.run();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public boolean check_flags() {
    if (speed < 0) {
      System.out.println("'--speed' must be a positive.");
      return false;
    } else if (speed > 0) {
      settings.setIterationTimeInterval(Duration.ofMillis(speed));
    }

    if (size != null) {
      if (size.get(0) <= 0 || size.get(1) <= 0) {
        System.out.println("'--size' elements must be positive.");
        return false;
      }
      settings.setHeight(size.get(0));
      settings.setWidth(size.get(1));
    }

    if (iters_count < -1) {
      System.out.println("'--iters_count' must be positive or -1 (-1 for infinite game)");
      return false;
    } else if (iters_count > 0) {
      settings.setIterationCount(iters_count);
    }
    return true;
  }
}
