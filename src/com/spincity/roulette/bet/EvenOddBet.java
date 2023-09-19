package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;

class EvenOddBet implements BetCalculator {
    public Bet bet;

    public EvenOddBet(Bet bet) {
        setBet(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {

        // Zero is not considered even/odd in roulette
        if (spinnerNumber.getNumber() == 0) {
            return 0.0;
        }

        // Check if the spinnerNumber is even or odd
        boolean isEven = spinnerNumber.getNumber() % 2 == 0;

        if ((bet.getOption() == BetType.EvenOdd.EVEN && isEven) ||
                (bet.getOption() == BetType.EvenOdd.ODD && !isEven)) {
            return bet.getChip().value() * bet.getType().multiplier();
        }

        // Return 0 if the bet is not a win
        return 0.0;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
