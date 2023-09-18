package com.spincity.roulette;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetCalculator;
import com.spincity.roulette.bet.BettingFactory;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Game {
    private Bet bettingCategory;
    private Bet.Color colorOption;
    private Board board;
    Prompter prompter = new Prompter(new Scanner(System.in));
    private final CountDownLatch latch = new CountDownLatch(1);

    JFrame frame = new JFrame("Wish you Good Luck");

    public Game() {
        board = new Board();
    }

    public void gameStats(Player player) {
        System.out.println("Account Balance: " + player.getAccountBalance() + "                              Player: " + player.getPlayerName());
    }

    public void selectBet(Player player) {
        gameStats(player);
        board.display();

        System.out.println("\nEnter bet amount:");
        System.out.println("\nSelect bet category: ");
        System.out.println("\nSelect bet option: ");

        // Selection Options
        bettingCategory = Bet.COLOR;
        colorOption = Bet.Color.BLACK;

        Console.clear();
        gameStats(player);

        board.display();

        SwingUtilities.invokeLater(() -> {

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Spinner spinner = new Spinner();
            frame.add(spinner);
            frame.setSize(655, 700);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.toFront();
            frame.setAlwaysOnTop(true);

            spinner.spin(new SpinCompletionCallback() {
                @Override
                public void onSpinComplete(SpinnerNumber pickedNumber) {
                    // Use the pickedNumber from the spinner wheel here
                    BetCalculator betCalculatorCalculator = BettingFactory.bettingStrategy(bettingCategory);
                    double winAmount = betCalculatorCalculator.calculateWinLoss(pickedNumber, colorOption);
                    if (winAmount == 0.0) {
                        player.setAccountBalance(player.getAccountBalance() - 500);
                        System.out.println("You lost");
                        gameStats(player);
                        latch.countDown();
                    } else {
                        player.setAccountBalance(player.getAccountBalance() + 500);
                        System.out.println("You Won");
                        gameStats(player);
                        latch.countDown();

                    }
                }
            });
        });

        try {
            latch.await(); // Wait for the Swing event to complete
            frame.dispose(); // Exit the spinner wheel frame here

            // Present user with the options to continue or logout
            System.out.println("");
            System.out.println("1. Place another bet");
            System.out.println("2. Logout from the game");
            System.out.println("");
            int input = Integer.parseInt(prompter.prompt("Enter your choice: ", "\\d{1,2}", "Invalid choice. Please select 1 or 2.\n"));
            if (input == 1) {
                Game game = new Game();
                game.selectBet(player);
            } else {
                Login.start();
            }
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

    }

}
