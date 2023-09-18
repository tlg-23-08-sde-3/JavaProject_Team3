package com.spincity.roulette.spinner;

import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.bet.BetType.Color.*;

public enum SpinnerNumber {
    ZERO(0, NO_COLOR),
    ONE(1, RED),
    TWO(2, BLACK),
    THREE(3, RED),
    FOUR(4, BLACK),
    FIVE(5, RED),
    SIX(6, BLACK),
    SEVEN(7, RED),
    EIGHT(8, BLACK),
    NINE(9, RED),
    TEN(10, BLACK),
    ELEVEN(11, BLACK),
    TWELVE(12, RED),
    THIRTEEN(13, BLACK),
    FOURTEEN(14, RED),
    FIFTEEN(15, BLACK),
    SIXTEEN(16, RED),
    SEVENTEEN(17, BLACK),
    EIGHTEEN(18, RED),
    NINETEEN(19, RED),
    TWENTY(20, BLACK),
    TWENTY_ONE(21, RED),
    TWENTY_TWO(22, BLACK),
    TWENTY_THREE(23, RED),
    TWENTY_FOUR(24, BLACK),
    TWENTY_FIVE(25, RED),
    TWENTY_SIX(26, BLACK),
    TWENTY_SEVEN(27, RED),
    TWENTY_EIGHT(28, BLACK),
    TWENTY_NINE(29, BLACK),
    THIRTY(30, RED),
    THIRTY_ONE(31, BLACK),
    THIRTY_TWO(32, RED),
    THIRTY_THREE(33, BLACK),
    THIRTY_FOUR(34, RED),
    THIRTY_FIVE(35, BLACK),
    THIRTY_SIX(36, RED);

    private final int number;
    private final BetType.Color color;

    SpinnerNumber(int number, BetType.Color color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public BetType.Color color() {
        return color;
    }
}
