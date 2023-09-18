package com.spincity.roulette;

import static com.spincity.roulette.BetType.EvenOdd.*;
import static com.spincity.roulette.BetType.Dozen.*;
import static com.spincity.roulette.BetType.Color.*;

public enum SpinnerNumber {
    ZERO(0, NO_GROUP, NOT_EVEN_ODD, NO_COLOR),
    ONE(1, DOZEN_1_TO_12, ODD, RED),
    TWO(2, DOZEN_1_TO_12, EVEN, BLACK),
    THREE(3, DOZEN_1_TO_12, ODD, RED),
    FOUR(4, DOZEN_1_TO_12, EVEN, BLACK),
    FIVE(5, DOZEN_1_TO_12, ODD, RED),
    SIX(6, DOZEN_1_TO_12, EVEN, BLACK),
    SEVEN(7, DOZEN_1_TO_12, ODD, RED),
    EIGHT(8, DOZEN_1_TO_12, EVEN, BLACK),
    NINE(9, DOZEN_1_TO_12, ODD, RED),
    TEN(10, DOZEN_1_TO_12, EVEN, BLACK),
    ELEVEN(11, DOZEN_1_TO_12, ODD, BLACK),
    TWELVE(12, DOZEN_1_TO_12, EVEN, RED),
    THIRTEEN(13, DOZEN_13_TO_24, ODD, BLACK),
    FOURTEEN(14, DOZEN_13_TO_24, EVEN, RED),
    FIFTEEN(15, DOZEN_13_TO_24, ODD, BLACK),
    SIXTEEN(16, DOZEN_13_TO_24, EVEN, RED),
    SEVENTEEN(17, DOZEN_13_TO_24, ODD, BLACK),
    EIGHTEEN(18, DOZEN_13_TO_24, EVEN, RED),
    NINETEEN(19, DOZEN_13_TO_24, ODD, RED),
    TWENTY(20, DOZEN_13_TO_24, EVEN, BLACK),
    TWENTY_ONE(21, DOZEN_13_TO_24, ODD, RED),
    TWENTY_TWO(22, DOZEN_13_TO_24, EVEN, BLACK),
    TWENTY_THREE(23, DOZEN_13_TO_24, ODD, RED),
    TWENTY_FOUR(24, DOZEN_13_TO_24, EVEN, BLACK),
    TWENTY_FIVE(25, DOZEN_25_TO_36, ODD, RED),
    TWENTY_SIX(26, DOZEN_25_TO_36, EVEN, BLACK),
    TWENTY_SEVEN(27, DOZEN_25_TO_36, ODD, RED),
    TWENTY_EIGHT(28, DOZEN_25_TO_36, EVEN, BLACK),
    TWENTY_NINE(29, DOZEN_25_TO_36, ODD, BLACK),
    THIRTY(30, DOZEN_25_TO_36, EVEN, RED),
    THIRTY_ONE(31, DOZEN_25_TO_36, ODD, BLACK),
    THIRTY_TWO(32, DOZEN_25_TO_36, EVEN, RED),
    THIRTY_THREE(33, DOZEN_25_TO_36, ODD, BLACK),
    THIRTY_FOUR(34, DOZEN_25_TO_36, EVEN, RED),
    THIRTY_FIVE(35, DOZEN_25_TO_36, ODD, BLACK),
    THIRTY_SIX(36, DOZEN_25_TO_36, EVEN, RED);

    private final int number;
    private final BetType.Dozen dozen;
    private final BetType.EvenOdd evenOddOption;
    private final BetType.Color color;

    SpinnerNumber(int number, BetType.Dozen dozen, BetType.EvenOdd evenOddOption, BetType.Color color) {
        this.number = number;
        this.dozen = dozen;
        this.evenOddOption = evenOddOption;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public BetType.Dozen getDozen() {
        return dozen;
    }

    public BetType.EvenOdd getEvenOddOption() {
        return evenOddOption;
    }

    public BetType.Color getColorOption() {
        return color;
    }
}
