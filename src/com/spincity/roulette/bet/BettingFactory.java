package com.spincity.roulette.bet;

import com.spincity.roulette.BetType;

public class BettingFactory {

    public static BetCalculator bettingStrategy(BetType bettingCategory) {

       switch (bettingCategory) {
           case COLOR:
               return new ColorBet();
           default:
               return null;
       }
    }
}
