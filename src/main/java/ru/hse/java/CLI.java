package ru.hse.java;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class CLI {
  public static void main(String ... args) {
    Args jArgs = new Args();
    JCommander helloCmd = JCommander.newBuilder()
        .addObject(jArgs)
        .build();
    helloCmd.parse(args);
    System.out.println("Hello " + jArgs.getName());
  }
}
