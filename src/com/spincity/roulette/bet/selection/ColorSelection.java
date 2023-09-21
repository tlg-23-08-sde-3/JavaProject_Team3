package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class ColorSelection extends BetOptionSelection {

    public ColorSelection(Prompter prompter) {
        super(prompter);
    }

    @Override
    public BetOption select() {
        System.out.println("Color Bets\n" +
                "\t1. Red\n" +
                "\t2. Black\n"
        );

        String colorInput = prompter.prompt("Select a color (1-2): ", "[1-2]", errorMessageInvalidSelection());
        BetType.Color colorBet = colorInput.equals("1") ? BetType.Color.RED : BetType.Color.BLACK;
        setBetOption(colorBet);

        return getBetOption();
    }
}
