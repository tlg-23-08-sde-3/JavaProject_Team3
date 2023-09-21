package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class EvenOddSelection extends BetOptionSelection {

    private final Prompter prompter;

    public EvenOddSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public BetOption select() {
        System.out.println("Even/Odd Bet\n" +
                "\t1. Even\n" +
                "\t2. Odd\n"
        );

        String evenOddInput = prompter.prompt("Select an option (1-2): ", "[1-2]", errorMessageInvalidSelection());
        BetType.EvenOdd evenOddOption = evenOddInput.equals("1") ? BetType.EvenOdd.EVEN : BetType.EvenOdd.ODD;
        setBetOption(evenOddOption);

        return getBetOption();
    }
}
