package ru.hse.java;

import java.util.HashMap;
import java.util.Map;

public class ConsoleColors {
    private final Map<String, String> colors = new HashMap<String, String>();

    ConsoleColors() {
        colors.put("black", "\033[0;30m");   // BLACK
        colors.put("red", "\033[0;31m");     // RED
        colors.put("green", "\033[0;32m");   // GREEN
        colors.put("yellow", "\033[0;33m");  // YELLOW
        colors.put("blue", "\033[0;34m");    // BLUE
        colors.put("purple", "\033[0;35m");  // PURPLE
        colors.put("cyan", "\033[0;36m");    // CYAN
        colors.put("white", "\033[0;37m");   // WHITE
    }

    String GetConsoleColor(String color) {
        return colors.get(color);
    }
}