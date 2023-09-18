package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;
import com.spincity.roulette.BetType.Column;

public class ColumnBet implements BetCalculator {
    private Bet bet;

    public ColumnBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();

        // Check if the spinner number is 0
        if (number == 0) {
            return 0.0;
        }

        // Determine which column the spinner number is in
        int column;

        if (number % 3 == 1) {
            column = 1;
        } else if (number % 3 == 2) {
            column = 2;
        } else {
            column = 3;
        }

        // Check the user bet with spinner column
        if (bet.getOption() == Column.values()[column]) {
            return bet.getChip().value() * bet.getType().multiplier();
        }

        // Return 0 if no win
        return 0.0;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
