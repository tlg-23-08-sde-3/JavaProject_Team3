package com.spincity.roulette.bet.selection;

import com.spincity.roulette.bet.BetType;

public class BetOptionSelectionFactory {

    public static BetOptionSelection getSelector(BetType betType) {
        switch (betType) {
            case SINGLE_NUMBER:
                return new SingleNumberSelection();
            case COLOR:
                return new ColorSelection();
            case DOZEN:
                return new DozenSelection();
            case COLUMN:
                return new ColumnSelection();
            case EVEN_ODD:
                return new EvenOddSelection();
            case HIGH_LOW:
                return new HighLowSelection();
        }

        return null;
    }

}
