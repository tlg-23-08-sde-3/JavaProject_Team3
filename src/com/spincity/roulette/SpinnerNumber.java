package com.spincity.roulette;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SpinnerNumber {
    ONE(1, BasketOption.BASKET_1_TO_12, EvenOddOption.ODD, ColorOption.RED),
    TWO(2, BasketOption.BASKET_1_TO_12, EvenOddOption.EVEN, ColorOption.BLACK);

    private int number;
    private BasketOption basketOption;
    private EvenOddOption evenOddOption;
    private ColorOption colorOption;

    SpinnerNumber(int number, BasketOption basketOption, EvenOddOption evenOddOption, ColorOption colorOption) {
        this.number = number;
        this.basketOption = basketOption;
        this.evenOddOption = evenOddOption;
        this.colorOption = colorOption;
    }

    public int getNumber() {
        return number;
    }

    public BasketOption getBasketOption() {
        return basketOption;
    }

    public EvenOddOption getEvenOddOption() {
        return evenOddOption;
    }

    public ColorOption getColorOption() {
        return colorOption;
    }
}
