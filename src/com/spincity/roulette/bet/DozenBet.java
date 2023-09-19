package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.Dozen;

public class DozenBet implements BetCalculator {
    private Bet bet;

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
        if (bet.getOption() == selectedDozen) {
            return bet.getChip().value() * bet.getType().multiplier();
        }

        // Return 0 if not a win
        return 0.0;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
