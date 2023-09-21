package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;

import java.util.Scanner;

public abstract class BetOptionSelection {
    private BetOption betOption;
    public Prompter prompter;

    public BetOptionSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    public abstract BetOption select();

    public void setBetOption(BetOption betOption) {
        this.betOption = betOption;
    }

    public BetOption getBetOption() {
        return betOption;
    }
}
