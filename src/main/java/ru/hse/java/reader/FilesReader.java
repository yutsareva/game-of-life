package ru.hse.java.reader;

import ru.hse.java.settings.Settings;
import ru.hse.java.settings.parser.InvalidSettings;
import ru.hse.java.settings.parser.SettingsParser;


public class FilesReader extends Reader {
    private final String settingsFileName;

    public FilesReader(String settingsFileName) {
        this.settingsFileName = settingsFileName;
    }

    @Override
    public Settings readSettings() throws InvalidSettings {
        return SettingsParser.parse(this.settingsFileName);
    }
}
