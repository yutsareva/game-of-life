package ru.hse.java.commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import java.util.HashSet;
import java.util.Set;
import ru.hse.java.CLI;
import ru.hse.java.reader.FilesReader;
import ru.hse.java.settings.AutomationRules;
import ru.hse.java.settings.Settings;
import ru.hse.java.writer.FilesWriter;

@Parameters(
    commandNames = { "set_rules" },
    commandDescription = "Change rules."
)
public class SetRulesCommand implements Command {

  @Parameter(
      names = "--revive",
      description = "Alive neighbors to revive. Format: '1,2,3'"
  )
  private String revive;

  @Parameter(
      names = "--die",
      description = "Alive neighbors to die. Format: '1,2,3'"
  )
  private String die;
  @Override
  public void run() {
    String[] reviveArr = new String[]{};
    if (revive != null) {
      reviveArr = revive.split(",");
    }
    String[] dieArr = new String[]{};
    if (die != null) {
      dieArr = die.split(",");
    }
    Set<Integer> reviveSet = new HashSet<Integer>();
    Set<Integer> dieSet = new HashSet<Integer>();
    for (var val : reviveArr) {
      reviveSet.add(Integer.parseInt(val));
    }
    for (var val : dieArr) {
      dieSet.add(Integer.parseInt(val));
    }
    FilesWriter writer = new FilesWriter(CLI.CURRENT_CONFIG_FILE);
    AutomationRules rules = new AutomationRules(reviveSet, dieSet);
    writer.writeAutomationRules(rules);
  }

  @Override
  public boolean check_flags() {
    return true;
  }
}
