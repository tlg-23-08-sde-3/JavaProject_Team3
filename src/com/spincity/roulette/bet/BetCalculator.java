package com.spincity.roulette.bet;

import com.spincity.roulette.BettingCategory;
import com.spincity.roulette.SpinnerNumber;

public interface BetCalculator {
    default public double calculateWinLoss(SpinnerNumber spinnerNumber, int number) {
        return 0.0;
    };

        default public  double calculateWinLoss(SpinnerNumber spinnerNumber, BettingCategory.Dozen dozenOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, BettingCategory.EvenOdd evenOddOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, BettingCategory.Color colorOption) {
        return 0.0;
    }

    // spinner-1.jpg

}

