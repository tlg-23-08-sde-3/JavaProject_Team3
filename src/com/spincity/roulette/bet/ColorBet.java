package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.SpinnerNumber;

class ColorBet implements BetCalculator {
    public Bet bet;

    public ColorBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        // Do some calculation

        if (bet.getOption().equals(spinnerNumber.color())) {
            return bet.getAmount() * bet.getType().multiplier();
        }

        return 0.0;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

}
