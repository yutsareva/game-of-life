package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import ru.hse.java.CLI;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Runner;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

@Parameters(
    commandNames = { "show_start" },
    commandDescription = "Show starting board."
)
public class ShowStartCommand implements Command {

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE, "");
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
