package com.spincity.roulette;

import com.apps.util.Console;
import com.spincity.roulette.bet.BetCalculator;
import com.spincity.roulette.bet.BettingFactory;

import javax.swing.*;

public class Game {
    private BettingCategory bettingCategory;
    private BettingCategory.Color colorOption;

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
        colorOption = BettingCategory.Color.BLACK;

        Console.clear();
        gameStats();
        Board.displayBoard();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Wish you Good Luck");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Spinner spinner = new Spinner();
            frame.add(spinner);
            frame.setSize(655, 700);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

            spinner.spin(new SpinCompletionCallback() {
                @Override
                public void onSpinComplete(SpinnerNumber pickedNumber) {
                    // Use the pickedNumber here
                    System.out.println(pickedNumber);
                    BetCalculator betCalculatorCalculator = BettingFactory.bettingStrategy(bettingCategory);
                    double winAmount = betCalculatorCalculator.calculateWinLoss(pickedNumber, colorOption);
                    if (winAmount == 0.0) {
                        System.out.println("you lost");
                    } else {
                        System.out.println("Your Won");
                    }
                }
            });


        });
    }

}
