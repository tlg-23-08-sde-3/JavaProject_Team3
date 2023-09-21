package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;

import java.util.Scanner;

public class BetOptionSelectionFactory {
   public static Prompter prompter = new Prompter(new Scanner(System.in));

    public static BetOptionSelection getSelector(BetType betType) {
        switch (betType) {
            case SINGLE_NUMBER:
                return new SingleNumberSelection(prompter);
            case COLOR:
                return new ColorSelection(prompter);
            case DOZEN:
                return new DozenSelection(prompter);
            case COLUMN:
                return new ColumnSelection(prompter);
            case EVEN_ODD:
                return new EvenOddSelection(prompter);
            case HIGH_LOW:
                return new HighLowSelection(prompter);
        }

        return null;
    }

}
