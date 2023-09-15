package com.spincity.roulette.bet;

import com.spincity.roulette.ColorOption;
import com.spincity.roulette.SpinnerNumber;

class ColorBet implements WinLoss {
    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber, ColorOption colorOption) {
        // Do some calculation

        if (colorOption == spinnerNumber.getColorOption()) {
            return 1.0;

        }

        return 0.0;
    }
}
