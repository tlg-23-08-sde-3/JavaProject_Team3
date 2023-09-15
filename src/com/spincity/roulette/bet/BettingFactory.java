package com.spincity.roulette.bet;

import com.spincity.roulette.BettingCategory;

public class BettingFactory {

    public static BetCalculator getWinLossStrategy(BettingCategory bettingCategory) {
       switch (bettingCategory) {
           case COLOR:
               return new ColorBet();
           default:
               return null;
       }
    }
}
