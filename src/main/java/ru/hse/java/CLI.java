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
  public static final String DEFAULT_PARAMETERS_FILE = "src/main/java/resources/default_params.txt";
  public static final String CURRENT_PARAMETERS_FILE = "src/main/java/resources/params.txt";
  public static final String DEFAULT_RULES_FILE = "src/main/java/resources/default_rules.txt";
  public static final String CURRENT_RULES_FILE = "src/main/java/resources/rules.txt";
  public static final String INITIAL_CONFIGURATION = "src/main/java/resources/initial_configuration.txt";

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

        case "help":
          jc.usage();
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
