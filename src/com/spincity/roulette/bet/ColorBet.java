package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;

class ColorBet implements BetCalculator {
    public static int multiplier = 2;

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber, Bet bet) {
        // Do some calculation

        if (bet.getOption().equals(spinnerNumber.getColorOption())) {
            return 1.0;
        }

        return 0.0;
    }
}
