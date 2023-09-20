package com.spincity.roulette.bet;

import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.SingleNumber;

public class SingleNumberBet extends BetCalculator {

    public SingleNumberBet(Bet bet) {
        super(bet);
    }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();

        if (getBet().getOption() == SingleNumber.values()[number]) {
            return getBet().getChip().value() * getBet().getType().multiplier();
        }

        // Return 0 if no win
        return 0.0;
    }

}
