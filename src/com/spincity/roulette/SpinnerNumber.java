package com.spincity.roulette;

public enum SpinnerNumber {

        ONE(1, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWO(2, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        THREE(3, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        FOUR(4, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        FIVE(5, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        SIX(6, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        SEVEN(7, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        EIGHT(8, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        NINE(9, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TEN(10, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        ELEVEN(11, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWELVE(12, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        THIRTEEN(13, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        FOURTEEN(14, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        FIFTEEN(15, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        SIXTEEN(16, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        SEVENTEEN(17, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        EIGHTEEN(18, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        NINETEEN(19, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWENTY(20, BettingCategory.Dozen.DOZEN_13_TO_24, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        TWENTY_ONE(21, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWENTY_TWO(22, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        TWENTY_THREE(23, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWENTY_FOUR(24, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        TWENTY_FIVE(25, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWENTY_SIX(26, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        TWENTY_SEVEN(27, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
        TWENTY_EIGHT(28, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK),
        TWENTY_NINE(29, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        THIRTY(30, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        THIRTY_ONE(31, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        THIRTY_TWO(32, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        THIRTY_THREE(33, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        THIRTY_FOUR(34, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED),
        THIRTY_FIVE(35, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.ODD, BettingCategory.Color.BLACK),
        THIRTY_SIX(36, BettingCategory.Dozen.DOZEN_25_TO_36, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.RED);


    private int number;
    private BettingCategory.Dozen dozen;
    private BettingCategory.EvenOdd evenOddOption;
    private BettingCategory.Color color;

    SpinnerNumber(int number, BettingCategory.Dozen basketOption, BettingCategory.EvenOdd evenOddOption, BettingCategory.Color color) {
        this.number = number;
        this.dozen = basketOption;
        this.evenOddOption = evenOddOption;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public BettingCategory.Dozen getDozen() {
        return dozen;
    }

    public BettingCategory.EvenOdd getEvenOddOption() {
        return evenOddOption;
    }

    public BettingCategory.Color getColorOption() {
        return color;
    }
}
