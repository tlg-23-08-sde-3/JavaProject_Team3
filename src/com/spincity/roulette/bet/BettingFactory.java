package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;

public class BettingFactory {

    public static BetCalculator bettingStrategy(Bet bettingCategory) {

       switch (bettingCategory) {
           case COLOR:
               return new ColorBet();
           default:
               return null;
       }
    }
}
