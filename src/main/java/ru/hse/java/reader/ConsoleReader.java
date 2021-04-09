package ru.hse.java.reader;

import ru.hse.java.settings.Settings;

public class ConsoleReader extends Reader {

    @Override
    void readField() {
        System.out.println("ConsoleReader/@readField");
    }

    @Override
    Settings readSettings() {
        System.out.println("ConsoleReader/@readRules");
        return null;
    }
}
