package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Runner;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

@Parameters(
    commandNames = { "show_board" },
    commandDescription = "Show given board."
)
public class ShowBoardCommand implements Command {
  @Parameter(
      names = "--file",
      description = "Input file.",
      required = true
  )
  private String file;
  
  @Override
  public void run() {
    FilesReader reader = new FilesReader(file, "");
    Settings settings = reader.readSettings();
    settings.setIterationCount(1);
    Runner runner = new Runner(settings, new ConsoleDisplay());
    try {
      runner.run();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
