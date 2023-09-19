package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.Column;

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
        Column selectedColumn;

        if (number % 3 == 1) {
           selectedColumn = Column.COLUMN_1_ENDS_34;
        } else if (number % 3 == 2) {
            selectedColumn = Column.COLUMN_2_ENDS_35;
        } else {
            selectedColumn = Column.COLUMN_3_ENDS_36;
        }

        // Check the user bet with spinner column
        if (bet.getOption() == selectedColumn) {
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
