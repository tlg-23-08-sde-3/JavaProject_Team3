package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;
import com.spincity.roulette.BetType.Dozen;

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

        // Determine which dozen the spinner number belongs to
        int dozen;

        if (number >= 1 && number <= 12) {
            dozen = 1;
        } else if (number >= 13 && number <= 24) {
            dozen = 2;
        } else {
            dozen = 3;
        }

        // Check for the match
        if (bet.getOption() == Dozen.values()[dozen]) {
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
