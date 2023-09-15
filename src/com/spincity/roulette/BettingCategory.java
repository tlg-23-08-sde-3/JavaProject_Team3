package com.spincity.roulette;

public enum BettingCategory {
    STRAIGHT_UP,
    BASKET,
    COLOR,
    EVEN_ODD;

    public static enum EvenOdd {
        EVEN,
        ODD;
    }

    public static enum Color {
        RED,
        BLACK;
    }

    public static enum Dozen {
      DOZEN_1_TO_12,
      DOZEN_13_TO_24,
      DOZEN_25_TO_36;
    }
}
