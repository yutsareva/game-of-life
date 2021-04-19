package ru.hse.java.reader;

import ru.hse.java.settings.Settings;
import ru.hse.java.settings.parser.SettingsParser;

public class FilesReader extends Reader {
    private final String settingsFileName;
    private final String fieldFileName;

    public FilesReader(String settingsFileName, String fieldFileName) {
        this.settingsFileName = settingsFileName;
        this.fieldFileName = fieldFileName;
    }

    @Override
    void readField() {
        System.out.println("FilesReader/@readField");
    }

    @Override
    public Settings readSettings() {
        return SettingsParser.parse(this.settingsFileName);
    }
}
