package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Display;
import ru.hse.java.Runner;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.SettingsFromFile;
import ru.hse.java.settings.StandartSettings;

import java.util.List;

@Parameters(
    commandNames = { "run" },
    commandDescription = "Run simulation."
)
public class RunCommand implements Command {
  @Parameter(
      names = "--speed",
      description = "Simulation speed."
  )
  private double speed;

  @Parameter(
      names = "--size",
      description = "Board size."
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

  @Override
  public void run() {
    System.out.println("RunCommand");
//    try {
//      FilesReader reader = new FilesReader("DataExample.json", "");
//      SettingsFromFile settings = reader.readSettings();
//      Runner runner = new Runner(settings, new ConsoleDisplay());
//    } catch (Exception e) {
//      System.out.println("mem");
//    }
    Runner runner = new Runner(new StandartSettings(), new ConsoleDisplay());
    try {
      runner.run();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void check_flags() {
    if (speed <= 0) {
      System.out.println("'--speed' must be a positive.");
      return;
    }
    if (size.size() != 2) {
      System.out.println("'--size' must be an array of size 2.");
      return;
    }
    if (size.get(0) <= 0 || size.get(1) <= 0) {
      System.out.println("'--size' elements must be positive.");
      return;
    }
    if (iters_count <= 0) {
      System.out.println("'--iters_count' must be positive.");
      return;
    }
  }
}
