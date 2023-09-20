package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.HighLow;

public class HighLowBet extends BetCalculator {

    public HighLowBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();

        // Check if the spinner number is 0
        if (number == 0) {
            return 0.0;
        }

        // Check spinner number is low (1-18) or high (19-36)
        boolean isLow = number >= 1 && number <= 18;
        boolean isHigh = number >= 19 && number <= 36;

        if (getBet().getOption() == HighLow.LOW_1_TO_18 && isLow) {
            return getBet().getChip().value() * getBet().getType().multiplier();
        } else if (getBet().getOption() == HighLow.HIGH_19_TO_36 && isHigh) {
            return getBet().getChip().value() * getBet().getType().multiplier();
        }

        // Return 0 if no win
        return 0.0;
    }

}
