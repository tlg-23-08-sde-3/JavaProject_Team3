package com.spincity.roulette.utils;

public class ANSI {

    public static String colorYellow(String text) {
        return ANSI.Color.YELLOW + text + ANSI.Color.RESET;
    }

    public static String colorGrey(String text) {
        return Color.GREY + text + ANSI.Color.RESET;
    }

    public static String colorRed(String text) {
        return ANSI.Color.RED + text + ANSI.Color.RESET;
    }

    public static String colorGreen(String text) {
        return Color.GREEN + text + Color.RESET;
    }

    // Foreground Colors
    public static enum Color {
        RESET("0m"),
        YELLOW("33m"),
        GREEN("38;5;28m"),
        BRIGHT_YELLOW("93m"),
        RED("38;5;160m"),
        BLACK("30m"),
        WHITE("97m"),
        OFF_WHITE("38;5;251m"),
        GREY("38;5;247m"),
        BLUE("38;5;21m"),
        ORANGE("38;5;209m"),
        PURPLE("38;5;92m"),
        MAGENTA("35m"),
        BRIGHT_MAGENTA("38;5;126m");


        private final String value;

        Color(String ansiCode) {
            this.value = "\u001B[" + ansiCode;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }

    // Background Colors
    public static enum BackgroundColor {
        GREEN("48;5;28m"),
        BLACK("48;5;0m"),
        BRIGHT_GREEN("102m");


        private final String value;

        BackgroundColor(String ansiCode) {
            this.value = "\u001B[" + ansiCode;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }
}
