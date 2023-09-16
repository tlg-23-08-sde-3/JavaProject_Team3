package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;

public interface BetCalculator {
    default public double calculateWinLoss(SpinnerNumber spinnerNumber, int number) {
        return 0.0;
    };

        default public  double calculateWinLoss(SpinnerNumber spinnerNumber, Bet.Dozen dozenOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, Bet.EvenOdd evenOddOption) {
        return 0.0;
    }

    default  public double calculateWinLoss(SpinnerNumber spinnerNumber, Bet.Color colorOption) {
        return 0.0;
    }

    // spinner-1.jpg

}

