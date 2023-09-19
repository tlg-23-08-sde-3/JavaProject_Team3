package com.spincity.roulette.bet.selection;

import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class HighLowSelection extends BetOptionSelection {

    @Override
    public BetOption select() {
        System.out.println("High/Low Bet\n" +
                "\t1. Low (1-18)\n" +
                "\t2. High (19-36)\n"
        );

        String highLowInput = prompter.prompt("Select an option (1-2): ", "[1-2]", errorMessageInvalidSelection());
        if ("1".equals(highLowInput)) {
            setBetOption(BetType.HighLow.LOW_1_TO_18);
        } else {
            setBetOption(BetType.HighLow.HIGH_19_TO_36);
        }

        return getBetOption();
    }
}
