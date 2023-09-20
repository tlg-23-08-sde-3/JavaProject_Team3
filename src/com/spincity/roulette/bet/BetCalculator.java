package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;

public abstract class BetCalculator {
    private Bet bet;

    public BetCalculator(Bet bet) {
        this.bet = bet;

    }

    public abstract double calculateWinLoss(SpinnerNumber spinnerNumber);

    public Bet getBet() {
        return bet;
    }
}

