package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class SingleNumberSelection extends BetOptionSelection {

    private final Prompter prompter;

    public SingleNumberSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public BetOption select() {
        String singleNumberInput = prompter.prompt("Choose a number to bet (0-36): ", "([0-9]|[12][0-9]|3[0-6])", errorMessageInvalidSelection());
        int singleNumberSelection = Integer.parseInt(singleNumberInput);

        // Update bet options with the corresponding bet
        for (var singleNumberEnum : BetType.SingleNumber.values()) {
            if (singleNumberEnum.value() == singleNumberSelection) {
                setBetOption(singleNumberEnum); // set the selected betOption;
                break;
            }
        }

        return getBetOption(); // return the selected betOption
    }
}
