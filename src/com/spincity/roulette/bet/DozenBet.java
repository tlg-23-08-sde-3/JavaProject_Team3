package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.Dozen;

public class DozenBet extends BetCalculator {

    public DozenBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();

        // Check if the spinner number is "0"
        if (number == 0) {
            return 0.0;
        }

        Dozen selectedDozen;

        if (number >= 1 && number <= 12) {
            selectedDozen = Dozen.DOZEN_1_TO_12;
        } else if (number >= 13 && number <= 24) {
            selectedDozen = Dozen.DOZEN_13_TO_24;
        } else {
            selectedDozen = Dozen.DOZEN_25_TO_36;
        }

        // Check for match
        if (getBet().getOption() == selectedDozen) {
            return getBet().getChip().value() * getBet().getType().multiplier();
        }

        // Return 0 if not a win
        return 0.0;
    }

}
