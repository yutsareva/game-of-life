package ru.hse.java.reader;

import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;

public abstract class Reader {
    abstract void readField();
//    abstract void readSettings() throws FileNotFoundException, ParseException;
}
