package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class ColumnSelection extends BetOptionSelection {

    private final Prompter prompter;

    public ColumnSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    @Override
    public BetOption select() {
        System.out.println("Column Bets\n" +
                "\t1. First Column (Starts 1 - Ends 34)\n" +
                "\t2. Second Column (Starts 2 - Ends 35)\n" +
                "\t3. Third Column (Starts 3 - Ends 36)\n"
        );

        String columnInput = prompter.prompt("Select a column (1-3): ", "[1-3]", errorMessageInvalidSelection());
        switch (columnInput) {
            case "1":
                 setBetOption(BetType.Column.COLUMN_1_ENDS_34);
                break;
            case "2":
                 setBetOption(BetType.Column.COLUMN_2_ENDS_35);
                break;
            case "3":
                 setBetOption(BetType.Column.COLUMN_3_ENDS_36);
        }

        return getBetOption();
    }

}
