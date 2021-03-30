package ru.hse.java;

import com.beust.jcommander.Parameter;
import java.util.ArrayList;

public class Args {
  @Parameter(
      names = "--name",
      description = "User name",
      required = true
  )
  private String name;

  public String getName() {
    return name;
  }
}
