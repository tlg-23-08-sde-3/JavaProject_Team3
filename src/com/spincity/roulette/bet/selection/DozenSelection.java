package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class DozenSelection extends BetOptionSelection {

    private final Prompter prompter;

    public DozenSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public BetOption select() {

        System.out.println("Dozen Numbers Bet\n" +
                "\t1. 1-12\n" +
                "\t2. 13-34\n" +
                "\t3. 25-36\n"
        );

        String dozenInput = prompter.prompt("Select (1-3): ", "[1-3]", errorMessageInvalidSelection());

        switch (dozenInput) {
            case "1":
                setBetOption(BetType.Dozen.DOZEN_1_TO_12);
                break;
            case "2":
                setBetOption(BetType.Dozen.DOZEN_13_TO_24);
                break;
            case "3":
                setBetOption(BetType.Dozen.DOZEN_25_TO_36);
        }

        return getBetOption();
    }
}
