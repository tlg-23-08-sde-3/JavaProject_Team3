package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;

class EvenOddBet extends BetCalculator {

    public EvenOddBet(Bet bet) {
        super(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {

        // Zero is not considered even/odd in roulette
        if (spinnerNumber.getNumber() == 0) {
            return 0.0;
        }

        // Check if the spinnerNumber is even or odd
        boolean isEven = spinnerNumber.getNumber() % 2 == 0;

        if ((getBet().getOption() == BetType.EvenOdd.EVEN && isEven) ||
                (getBet().getOption() == BetType.EvenOdd.ODD && !isEven)) {
            return getBet().getChip().value() * getBet().getType().multiplier();
        }

        // Return 0 if the bet is not a win
        return 0.0;
    }

}
