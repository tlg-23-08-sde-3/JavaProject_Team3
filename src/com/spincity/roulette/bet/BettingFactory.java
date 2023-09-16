package com.spincity.roulette.bet;

import com.spincity.roulette.BettingCategory;

public class BettingFactory {

    public static BetCalculator bettingStrategy(BettingCategory bettingCategory) {
       switch (bettingCategory) {
           case COLOR:
               return new ColorBet();
           default:
               return null;
       }
    }
}
