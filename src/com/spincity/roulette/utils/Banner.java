package com.spincity.roulette.utils;

import static com.spincity.roulette.utils.ANSI.*;

public class Banner {
    public static void main(String[] args) {
        banner();
    }

    public static void banner() {
        System.out.println(Color.BRIGHT_YELLOW +
                " _______    ______   __    __  __        ________  ________  ________  ________ \n" +
                "/       \\  /      \\ /  |  /  |/  |      /        |/        |/        |/        |\n" +
                "$$$$$$$  |/$$$$$$  |$$ |  $$ |$$ |      $$$$$$$$/ $$$$$$$$/ $$$$$$$$/ $$$$$$$$/ \n" +
                "$$ |__$$ |$$ |  $$ |$$ |  $$ |$$ |      $$ |__       $$ |      $$ |   $$ |__    \n" +
                "$$    $$< $$ |  $$ |$$ |  $$ |$$ |      $$    |      $$ |      $$ |   $$    |   \n" +
                "$$$$$$$  |$$ |  $$ |$$ |  $$ |$$ |      $$$$$/       $$ |      $$ |   $$$$$/    \n" +
                "$$ |  $$ |$$ \\__$$ |$$ \\__$$ |$$ |_____ $$ |_____    $$ |      $$ |   $$ |_____ \n" +
                "$$ |  $$ |$$    $$/ $$    $$/ $$       |$$       |   $$ |      $$ |   $$       |\n" +
                "$$/   $$/  $$$$$$/   $$$$$$/  $$$$$$$$/ $$$$$$$$/    $$/       $$/    $$$$$$$$/"
                + Color.RESET
        );
    }
}
