package com.spincity.roulette;

import com.apps.util.Prompter;
import com.spincity.roulette.utils.ANSI;

import java.util.concurrent.CountDownLatch;
import javax.swing.*;
import java.util.Scanner;

public class Game {
    private BetType bettingCategory;
    private Board board;
    private SpinnerNumber winningNumber;
    private BetOption betOption;
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        // TODO: Remove in final version
        Game game = new Game();
        game.play();
    }

    public Game() {
        board = new Board();
    }

    public void gameStats() {
        System.out.printf("Player Name: %48s Account Balance: $%,.2f", "Jojo", 2500.0);
    }

    public void play() {
        gameStats();
        board.display();
        betSelection();


//
//        // Selection Options
//        bettingCategory = Bet.COLOR;
//        bettingOption = Bet.Color.RED;
//        winningNumber = SpinnerNumber.FIVE;
//
//        Console.clear();
//        gameStats();
//        board.display();
//
//        BetCalculator betCalculatorCalculator = BettingFactory.bettingStrategy(bettingCategory);
//        double winAmount = betCalculatorCalculator.calculateWinLoss(winningNumber, 100.0, bettingOption);
//
//        if (winAmount == 0.0) {
//            System.out.println("you lost");
//        } else {
//            System.out.println("Your Won");
//        }

    }

    private void betSelection() {
        System.out.println("Bet Types\n" +
                "\t1. Number Bet\n" +
                "\t2. Dozen Bet\n" +
                "\t3. Color Bet\n" +
                "\t4. Even/Odd Bet\n" +
                "\t5. Line Bet\n" +
                "\t6. High/Low Bet\n"
        );

        String betInput = prompter.prompt("Select a bet type: ", "(1|2|3|4|5|6)", errorMessage());

        switch (betInput) {
            case "1":
                

        }


    }

    public void displaySpinner() {
        JFrame frame = new JFrame("Wish you Good Luck");

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
//                    System.out.println(pickedNumber);
                    winningNumber = pickedNumber;
                    latch.countDown();

                }
            });
        });

        // Exits the Spinner JFrame when you hit exit or after delay timer
        try {
            latch.await(); // Wait for the Swing event to complete
            frame.dispose(); // Exit the spinner wheel frame here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String errorMessage() {
        return ANSI.Color.RED + "Invalid Selection!" + ANSI.Color.RESET + " Please try again.\n\n";
    }

}
