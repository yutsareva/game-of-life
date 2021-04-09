package ru.hse.java.reader;

public class ConsoleReader extends Reader {

    @Override
    void readField() {
        System.out.println("ConsoleReader/@readField");
    }

//    @Override
//    void readSettings() {
//        System.out.println("ConsoleReader/@readRules");
//    }
}
