package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.SingleNumber;

public class SingleNumberBet implements BetCalculator {
    private Bet bet;

    public SingleNumberBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();

        if (bet.getOption() == SingleNumber.values()[number]) {
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
