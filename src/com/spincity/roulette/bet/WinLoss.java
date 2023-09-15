package com.spincity.roulette.bet;

import com.spincity.roulette.BasketOption;
import com.spincity.roulette.ColorOption;
import com.spincity.roulette.EvenOddOption;
import com.spincity.roulette.SpinnerNumber;

public interface WinLoss {
    default public double calculateWinLoss(SpinnerNumber spinnerNumber, int number) {
        return 0.0;
    };

    default public  double calculateWinLoss(SpinnerNumber spinnerNumber, BasketOption basketOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, EvenOddOption evenOddOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, ColorOption colorOption) {
        return 0.0;
    }

}

