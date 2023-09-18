package com.spincity.roulette.bet;

import com.spincity.roulette.Bet;
import com.spincity.roulette.BetType;

public class BettingFactory {

    public static BetCalculator bettingStrategy(Bet bet) {

       switch (bet.getType()) {
           case COLOR:
               return new ColorBet(bet);
           case EVEN_ODD:
               return new EvenOddBet(bet);
           case DOZEN:
               return new DozenBet(bet);
           case COLUMN:
               return new ColumnBet(bet);
           case HIGH_LOW:
               return new HighLowBet(bet);
           case SINGLE_NUMBER:
               return new SingleNumberBet(bet);
           default:
               return null;
       }
    }
}
