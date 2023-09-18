package com.spincity.roulette;

public enum Bet {
    STRAIGHT_UP,
    BASKET,
    COLOR,
    EVEN_ODD;

    public static enum EvenOdd {
        EVEN,
        ODD,
        NOT_EVEN_ODD;  // For Zero
    }

    public static enum Color {
        RED,
        BLACK,
        NO_COLOR;  // for Zero
    }

    public static enum Dozen {
        NO_GROUP,  // for Zero
        DOZEN_1_TO_12,
        DOZEN_13_TO_24,
        DOZEN_25_TO_36;
    }

    public static enum Column {
        NO_GROUP,   // for zero
        COLUMN_1_TO_34,
        COLUMN_2_TO_35,
        COLUMN_3_TO_36;
    }

    public static enum LowHigh {
        No_GROUP,   // for zero
        LOW_1_TO_18,
        HIGH_19_TO_36;
    }


}
