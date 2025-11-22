package org.example.utils;

import java.time.LocalTime;

public class Utils {
    private Utils() {
    }

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static String capitalize(String input) {
        if (isNullOrEmpty(input)) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static String repeat(String input, int times) {
        return input.repeat(times);
    }

    public static void log(String message) {
        System.out.println("[" + java.time.LocalDateTime.now() + "] " + message);
    }

    public static void printSection(String title, String color) {
        String ts = LocalTime.now().toString();

        System.out.println(color + "\n[" + ts + "] --- " + title + " ---" + ConsoleColors.RESET);
    }

    public static void printSection(String title) {
        printSection(title, ConsoleColors.WHITE);
    }
}