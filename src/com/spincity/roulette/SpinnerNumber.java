package com.spincity.roulette;

public enum SpinnerNumber {
    ONE(1, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.ODD, BettingCategory.Color.RED),
    TWO(2, BettingCategory.Dozen.DOZEN_1_TO_12, BettingCategory.EvenOdd.EVEN, BettingCategory.Color.BLACK);

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
