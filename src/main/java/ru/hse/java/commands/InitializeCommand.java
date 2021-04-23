package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import ru.hse.java.CLI;
import ru.hse.java.ConsoleDisplay;
import ru.hse.java.Runner;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "initialize" },
    commandDescription = "Initialize starting configuration of alive cells."
)
public class InitializeCommand implements Command {

  @Parameter(
      names = "--file",
      description = "Input file.",
      required = true
  )
  private String file;

  @Override
  public void run() {
    FilesReader reader = new FilesReader(file);
    FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
    Settings settings = reader.readSettings();
    writer.writeSettings(settings);
  }

  @Override
  public boolean check_flags() { return true; }
}
