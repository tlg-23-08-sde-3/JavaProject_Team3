package com.spincity.roulette.bet;

import com.spincity.roulette.BettingCategory;

public class WinLossFactory {

    public static WinLoss getWinLossStrategy(BettingCategory bettingCategory) {
       switch (bettingCategory) {
           case COLOR:
               return new ColorBet();
           default:
               return null;
       }
    }
}
