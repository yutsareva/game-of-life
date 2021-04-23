package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.time.Duration;
import java.util.List;
import ru.hse.java.CLI;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "set_params" },
    commandDescription = "Change simulation parameters."
)
public class SetParamsCommand implements Command {
  
  @Parameter(
      names = "--speed",
      description = "Simulation speed (ms)."
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
      names = "--color",
      description = "Color of alive cells."
  )
  private double color;

  private Settings settings;

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE);
    settings = reader.readSettings();
    if (check_flags()) {
      FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
      writer.writeSettings(settings);
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
    } else if (iters_count == -1 || iters_count > 0) {
      settings.setIterationCount(iters_count);
    }
    return true;
  }
}
