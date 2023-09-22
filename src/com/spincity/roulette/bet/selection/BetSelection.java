package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.Board;
import com.spincity.roulette.account.Player;
import com.spincity.roulette.bet.BetOption;
import com.spincity.roulette.bet.BetType;

import static com.spincity.roulette.utils.ANSI.colorGrey;
import static com.spincity.roulette.utils.ANSI.colorRed;
import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;

public class BetSelection {
    private final Prompter prompter;

    public BetSelection(Prompter prompter) {
        this.prompter = prompter;
    }

    /*
     * Select Bet Type
     */
    public BetType betTypeSelection() {
        System.out.println("Bet Types \n");
        BetType[] betTypes = BetType.values();

        StringBuilder betTypeMenuBuilder = new StringBuilder();
        for (int i = 0; i < betTypes.length; i++) {
            BetType currBetType = betTypes[i];
            betTypeMenuBuilder.append("  ")
                    .append(i + 1)
                    .append(". ")
                    .append(currBetType.menuText())
                    .append(" (")
                    .append(currBetType.multiplier())
                    .append("-to-1)\n");
        }

        System.out.println(betTypeMenuBuilder);
        int betInput = Integer.parseInt(prompter.prompt("Select a bet type: ", "[1-6]", errorMessageInvalidSelection()));
        return betTypes[betInput - 1]; // Array is 0-indexed, but user selection prompt starts at 1.
    }

    /*
     * Bet Option Selection
     */
    public BetOption betOptionSelection(BetType betType) {
        BetOptionSelection betOptionSelection = BetOptionSelectionFactory.getSelector(betType);
        assert betOptionSelection != null;
        return betOptionSelection.select();
    }

    /*
     * Select Bet Amount (Chip)
     */

    public Board.Chip selectChip(Player player) {
        Board.Chip selectedChip = null;

        // Build Selection Screen
        StringBuilder amountSelectionBuilder = new StringBuilder()
                .append("Select an amount to bet \n");

        Board.Chip[] chips = Board.Chip.values();
        for (int i = 0; i < chips.length; i++) {
            amountSelectionBuilder.append("\t")
                    .append(i + 1)
                    .append(". ")
                    .append(chips[i].getChip())
                    .append(" $")
                    .append(chips[i].value())
                    .append("\n");
        }

        System.out.println(amountSelectionBuilder);

        /*
         * Ask user for an amount to bet.
         */
        boolean userHasSelectedAnAmountToBet = false;
        while (!userHasSelectedAnAmountToBet) {
            String amountIdxString = prompter.prompt("Select an amount (1-" + chips.length + ") or enter " + colorGrey("\"x\"") + " to skip this bet: ",
                    "([1-" + chips.length + "]|[Xx])", errorMessageInvalidSelection());

            // Skip this bet
            if ("x".equals(amountIdxString) || "X".equals(amountIdxString)) {
                return selectedChip;  // Should return null
            }

            int amountIdxInput = Integer.parseInt(amountIdxString);
            // Array is 0-indexed, but for user selection starts at 1.
            selectedChip = chips[amountIdxInput - 1];
            double amountToValidate = selectedChip.value();

            if (amountToValidate > player.getAccountBalance()) {
                System.out.printf(colorRed("Insufficient Balance!") + " Maximum bet you can place is $%,.2f\n\n", player.getAccountBalance());
                continue;
            }

            userHasSelectedAnAmountToBet = true;
        }

        return selectedChip;
    }

}
