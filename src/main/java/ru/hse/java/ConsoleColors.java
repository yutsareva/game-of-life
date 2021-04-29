public class ConsoleColors {
    default String ConsoleColors(String color) {
        Map<String, String> colors = new HashMap<String, String>();
        map.put("black", "\033[0;30m");   // BLACK
        map.put("red", "\033[0;31m");     // RED
        map.put("greeb", "\033[0;32m");   // GREEN
        map.put("yellow", "\033[0;33m");  // YELLOW
        map.put("blue", "\033[0;34m");    // BLUE
        map.put("purple", "\033[0;35m");  // PURPLE
        map.put("cyan", "\033[0;36m");    // CYAN
        map.put("white", "\033[0;37m");   // WHITE
        return colors.get(color);
    }
}