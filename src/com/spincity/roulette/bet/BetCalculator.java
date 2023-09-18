package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.BetOption;
import com.spincity.roulette.SpinnerNumber;

public interface BetCalculator {
    public double calculateWinLoss(SpinnerNumber spinnerNumber, Bet bet);
}

