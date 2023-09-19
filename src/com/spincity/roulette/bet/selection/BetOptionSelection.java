package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import java.util.Scanner;

public abstract class BetOptionSelection {
    private BetOption betOption;
    public Prompter prompter = new Prompter(new Scanner(System.in));


    public abstract BetOption select();

    public void setBetOption(BetOption betOption) {
        this.betOption = betOption;
    }

    public BetOption getBetOption() {
        return betOption;
    }
}
