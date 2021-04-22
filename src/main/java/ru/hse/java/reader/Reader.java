package ru.hse.java.reader;

import org.json.simple.parser.ParseException;
import ru.hse.java.settings.Settings;

import java.io.FileNotFoundException;

public abstract class Reader {
    public abstract Settings readSettings() throws FileNotFoundException, ParseException;
}
