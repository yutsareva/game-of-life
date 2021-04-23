package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import ru.hse.java.CLI;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "reset" },
    commandDescription = "Reset simulation parameters to default values."
)
public class ResetCommand implements Command {

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.DEFAULT_CONFIG_FILE);
    FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
    Settings settings = reader.readSettings();
    writer.writeSettings(settings);
  }

  @Override
  public boolean check_flags() { return true; }
}
