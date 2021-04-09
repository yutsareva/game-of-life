package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.List;

@Parameters(
    commandNames = { "set_params" },
    commandDescription = "Change simulation parameters."
)
public class SetParamsCommand implements Command {
  @Parameter(
      names = "--speed",
      description = "Simulation speed (ms)."
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
      names = "--color",
      description = "Color of alive cells."
  )
  private double color;

  @Override
  public void run() {
    System.out.println("SetParamsCommand");
  }

  @Override
  public void check_flags() {

  }
}
