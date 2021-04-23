package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import ru.hse.java.CLI;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.Settings;

@Parameters(
    commandNames = { "get_params" },
    commandDescription = "Print current parameters of the simulation."
)
public class GetParamsCommand implements Command {

  @Override
  public void run() {
    FilesReader reader = new FilesReader(CLI.CURRENT_CONFIG_FILE);
    Settings settings = reader.readSettings();
    System.out.println("size: " +  settings.getHeight() + " " + settings.getWidth());
    System.out.println("iters_count: " +  settings.getIterationCount());
    System.out.println("speed: " +  settings.getIterationTimeInterval());
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
