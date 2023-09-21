package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;

import java.util.Scanner;

public class BetOptionSelectionFactory {

    public static BetOptionSelection getSelector(BetType betType) {
        switch (betType) {
            case SINGLE_NUMBER:
                return new SingleNumberSelection(new Prompter(new Scanner(System.in)));
            case COLOR:
                return new ColorSelection(new Prompter(new Scanner(System.in)));
            case DOZEN:
                return new DozenSelection(new Prompter(new Scanner(System.in)));
            case COLUMN:
                return new ColumnSelection(new Prompter(new Scanner(System.in)));
            case EVEN_ODD:
                return new EvenOddSelection(new Prompter(new Scanner(System.in)));
            case HIGH_LOW:
                return new HighLowSelection(new Prompter(new Scanner(System.in)));
        }

        return null;
    }

}
