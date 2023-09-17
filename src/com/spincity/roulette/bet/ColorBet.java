package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;

class ColorBet implements BetCalculator {
    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber, Bet.Color colorOption) {
        // Do some calculation

        if (colorOption == spinnerNumber.getColorOption()) {
            return 1.0;

        }

        return 0.0;
    }
}
