package ru.hse.java;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import java.io.IOException;

public class CLI {
  public static void main(String ... args) {
    RunCommand runCommand = new RunCommand();
    InitializeCommand initializeCommandCmd = new InitializeCommand();
    SetRulesCommand setRulesCommand = new SetRulesCommand();
    SetParamsCommand setParamsCommand = new SetParamsCommand();
    GetParamsCommand getParamsCommand = new GetParamsCommand();
    AddDotCommand addDotCommand = new AddDotCommand();
    RemoveDotCommand removeDotCommand = new RemoveDotCommand();
    AddFigureCommand addFigureCommand = new AddFigureCommand();
    ShowStartCommand showStartCommand = new ShowStartCommand();
    ResetCommand resetCommand = new ResetCommand();
    ShowBoardCommand showBoardCommand = new ShowBoardCommand();
    StopCommand stopCommand = new StopCommand();

    JCommander jc = JCommander.newBuilder()
        .addCommand(runCommand)
        .addCommand(initializeCommandCmd)
        .addCommand(setRulesCommand)
        .addCommand(setParamsCommand)
        .addCommand(getParamsCommand)
        .addCommand(addDotCommand)
        .addCommand(removeDotCommand)
        .addCommand(addFigureCommand)
        .addCommand(showStartCommand)
        .addCommand(resetCommand)
        .addCommand(showBoardCommand)
        .addCommand(stopCommand)
        .build();
    jc.parse(args);
    String parsedCmdStr = jc.getParsedCommand();
    try {
      switch (parsedCmdStr) {
        case "run":
          runCommand.run();
          break;

        case "initialize":
          initializeCommandCmd.run();
          break;

        case "set_rules":
          setRulesCommand.run();
          break;

        case "set_params":
          setParamsCommand.run();
          break;

        case "get_params":
          getParamsCommand.run();
          break;

        case "add_dot":
          addDotCommand.run();
          break;

        case "remove_dot":
          removeDotCommand.run();
          break;

        case "add_figure":
          addFigureCommand.run();
          break;

        case "show_start":
          showStartCommand.run();
          break;

        case "reset":
          resetCommand.run();
          break;

        case "show_board":
          showBoardCommand.run();
          break;

        case "stop":
          stopCommand.run();
          break;

        default:
          System.err.println("Invalid command: " + parsedCmdStr);
      }
    } catch (Exception e) {
      System.out.println("No command specified :/");
      System.out.println("Use 'help' command for more info.");
    }
  }
}
