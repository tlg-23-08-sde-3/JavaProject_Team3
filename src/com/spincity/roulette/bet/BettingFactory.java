package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.BetType;

public class BettingFactory {

    public static BetCalculator bettingStrategy(Bet bet) {

       switch (bet.getType()) {
           case COLOR:
               return new ColorBet(bet);
           default:
               return null;
       }
    }
}
