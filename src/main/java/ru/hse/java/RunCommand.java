package ru.hse.java;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

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
  }
}
