package com.spincity.roulette;

public enum BetType {
    STRAIGHT_UP,
    BASKET,
    COLOR,
    EVEN_ODD;

    public static enum EvenOdd implements BetOption {
        EVEN,
        ODD,
        NOT_EVEN_ODD;  // For Zero
    }

    public static enum Color implements BetOption {
        RED,
        BLACK,
        NO_COLOR;  // for Zero
    }

    public static enum Dozen implements BetOption {
        NO_GROUP,  // for Zero
        DOZEN_1_TO_12,
        DOZEN_13_TO_24,
        DOZEN_25_TO_36;
    }

    public static enum Column implements BetOption {
        No_COLUMN,
        COLUMN_1_ENDS_34,
        COLUMN_2_ENDS_35,
        COLUMN_3_ENDS_36;
    }

    public static enum HighLow implements BetOption {
        NOT_HIGH_LOW,
        LOW_1_TO_18,
        HIGH_19_TO_36;
    }

    public static enum SingleNumber implements BetOption {
        ZERO(0),
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        ELEVEN(11),
        TWELVE(12),
        THIRTEEN(13),
        FOURTEEN(14),
        FIFTEEN(15),
        SIXTEEN(16),
        SEVENTEEN(17),
        EIGHTEEN(18),
        NINETEEN(19),
        TWENTY(20),
        TWENTY_ONE(21),
        TWENTY_TWO(22),
        TWENTY_THREE(23),
        TWENTY_FOUR(24),
        TWENTY_FIVE(25),
        TWENTY_SIX(26),
        TWENTY_SEVEN(27),
        TWENTY_EIGHT(28),
        TWENTY_NINE(29),
        THIRTY(30),
        THIRTY_ONE(31),
        THIRTY_TWO(32),
        THIRTY_THREE(33),
        THIRTY_FOUR(34),
        THIRTY_FIVE(35),
        THIRTY_SIX(36);

        private final int value;

        SingleNumber(int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }
}
