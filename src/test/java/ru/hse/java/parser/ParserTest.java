package ru.hse.java.parser;

import org.junit.Test;
import ru.hse.java.settings.parser.InvalidSettings;
import ru.hse.java.settings.parser.SettingsParser;

public class ParserTest {

  @Test(expected = InvalidSettings.class)
  public void duplicate_cell_count_to_die_and_revive() {
    SettingsParser
        .parse("src/main/resources/test_data/test_duplicate_cell_count_to_die_and_revive.json");
  }

  @Test(expected = InvalidSettings.class)
  public void invalid_iteration_invalid() {
    SettingsParser
        .parse("src/main/resources/test_data/test_invalid_iteration_invalid.json");
  }

}
