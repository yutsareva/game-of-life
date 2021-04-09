package ru.hse.java;

import com.beust.jcommander.JCommander;
import ru.hse.java.commands.AddDotCommand;
import ru.hse.java.commands.AddFigureCommand;
import ru.hse.java.commands.GetParamsCommand;
import ru.hse.java.commands.HelpCommand;
import ru.hse.java.commands.InitializeCommand;
import ru.hse.java.commands.RemoveDotCommand;
import ru.hse.java.commands.ResetCommand;
import ru.hse.java.commands.RunCommand;
import ru.hse.java.commands.SetParamsCommand;
import ru.hse.java.commands.SetRulesCommand;
import ru.hse.java.commands.ShowBoardCommand;
import ru.hse.java.commands.ShowStartCommand;
import ru.hse.java.commands.StopCommand;

public class CLI {

  public static final String DEFAULT_CONFIG_FILE = "src/main/resources/default_configuration.json";
  public static final String CURRENT_CONFIG_FILE = "src/main/resources/current_configuration.json";

  public static void main(String... args) {
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
    HelpCommand helpCommand = new HelpCommand();

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
        .addCommand(helpCommand)
        .build();
    jc.parse(args);
    String parsedCmdStr = jc.getParsedCommand();
    switch (parsedCmdStr) {
      case "run" -> runCommand.run();
      case "initialize" -> initializeCommandCmd.run();
      case "set_rules" -> setRulesCommand.run();
      case "set_params" -> setParamsCommand.run();
      case "get_params" -> getParamsCommand.run();
      case "add_dot" -> addDotCommand.run();
      case "remove_dot" -> removeDotCommand.run();
      case "add_figure" -> addFigureCommand.run();
      case "show_start" -> showStartCommand.run();
      case "reset" -> resetCommand.run();
      case "show_board" -> showBoardCommand.run();
      case "stop" -> stopCommand.run();
      case "help" -> jc.usage();
      default -> System.err.println("Invalid command: " + parsedCmdStr);
    }
  }
}
