package com.spincity.roulette;

import com.apps.util.Console;
import com.spincity.roulette.bet.WinLoss;
import com.spincity.roulette.bet.WinLossFactory;

import java.awt.*;

public class Game {
    private BettingCategory bettingCategory;
    private ColorOption colorOption;

    public void gameStats() {
        System.out.println("Account Balance: $2,500.0                                Player: Jojo");
    }

    public void selectBet() {
        gameStats();
        Board.displayBoard();

        System.out.println("\nEnter bet amount:");
        System.out.println("\nSelect bet category: ");
        System.out.println("\nSelect bet option: ");

        // Selection Options
        bettingCategory = BettingCategory.COLOR;
        colorOption = ColorOption.BLACK;

        Console.clear();
        gameStats();
        Board.displayBoard();

        Spinner spinner = new Spinner();
        SpinnerNumber pickedNumber = spinner.spin();

        WinLoss winLossCalculator = WinLossFactory.getWinLossStrategy(bettingCategory);
        double winAmount = winLossCalculator.calculateWinLoss(pickedNumber, colorOption);

        if (winAmount == 0.0) {
            System.out.println("you lost");
        } else {
            System.out.println("Your Won");
        }

    }

}
