package ru.hse.java.commands;

import com.beust.jcommander.Parameters;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;
import ru.hse.java.CLI;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "clear" },
    commandDescription = "clear board"
)
public class ClearCommand implements Command {

  @Override
  public void run() {
    FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
    writer.writeInitialAliveCells(new ArrayList<Pair<Integer, Integer>>());
  }

  @Override
  public boolean check_flags() { return true;}
}
