package com.spincity.roulette;

import static com.spincity.roulette.utils.ANSI.*;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.swing.*;
import java.util.Scanner;

public class Game {
    private final Board board;
    private SpinnerNumber winningNumber;
    private BetType betType;
    private BetOption betOption;
    private Board.Chip chip;
    private double amount;
    private List<Bet> bets;
    private Player player;
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        // TODO: Remove in final version
        Account account = Account.createNewAccount("Kobi");
        Player testPlayer = account.getPlayer();
        Game game = new Game(testPlayer);
        game.play();
    }

    public Game(Player player) {
        setPlayer(player);
        board = new Board();
        bets = new ArrayList<>();
    }

    public void gameStats() {
        String accountBalanceText = String.format("Account Balance: $%,.2f", player.getAccountBalance());
        System.out.printf(" Player Name: %-55s %30s\n", player.getPlayerName(), accountBalanceText);
    }

    public void play() {
        /*
         * User selects multiple bets
         */
        while (true) {
            refreshScreen();
            Bet bet = betSelection();
            bets.add(bet);

            refreshScreen();
            System.out.println("***********************************************");
            System.out.println("**  Increase your odds by adding another bet **");
            System.out.println("***********************************************\n");
            String continueInput = prompter.prompt("Would you like to add another bet (Y/N): ", "[YyNn]", errorMessageInvalidEntry());

            if (continueInput.equals("N") || continueInput.equals("n")) {
                break;
            }
        }


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

    private Bet betSelection() {
        System.out.println("Bet Types\n" +
                "\t1. Number Bet\n" +
                "\t2. Dozen Bet\n" +
                "\t3. Color Bet\n" +
                "\t4. Even/Odd Bet\n" +
                "\t5. Column Bet\n" +
                "\t6. High/Low Bet\n"
        );

        String betInput = prompter.prompt("Select a bet type: ", "[1-6]", errorMessageInvalidSelection());
        refreshScreen();

        /*
         * Bet Option Selection
         */

        switch (betInput) {
            case "1":
                betType = BetType.SINGLE_NUMBER;
                String singleNumberInput = prompter.prompt("Choose a number to bet (0-36): ", "([0-9]|[12][0-9]|3[0-6])", errorMessageInvalidSelection());
                int singleNumberSelection = Integer.parseInt(singleNumberInput);

                // Update bet options with the corresponding bet
                for (var singleNumberEnum : BetType.SingleNumber.values()) {
                    if (singleNumberEnum.value() == singleNumberSelection) {
                        betOption = singleNumberEnum;
                        break;
                    }
                }
                break;

            case "2":
                betType = BetType.DOZEN;
                System.out.println("Dozen Numbers Bet\n" +
                        "\t1. 1-12\n" +
                        "\t2. 13-34\n" +
                        "\t3. 25-36\n"
                );

                String dozenInput = prompter.prompt("Select (1-3): ", "[1-3]", errorMessageInvalidSelection());

                switch (dozenInput) {
                    case "1":
                        betOption = BetType.Dozen.DOZEN_1_TO_12;
                        break;
                    case "2":
                        betOption = BetType.Dozen.DOZEN_13_TO_24;
                        break;
                    case "3":
                        betOption = BetType.Dozen.DOZEN_25_TO_36;
                }
                break;

            case "3":
                betType = BetType.COLOR;
                System.out.println("Color Bets\n" +
                        "\t1. Red\n" +
                        "\t2. Black\n"
                );

                String colorInput = prompter.prompt("Select a color (1-2): ", "[1-2]", errorMessageInvalidSelection());
                if (colorInput.equals("1")) {
                    betOption = BetType.Color.RED;
                } else {
                    betOption = BetType.Color.BLACK;
                }

                break;

            case "4":
                betType = BetType.EVEN_ODD;
                System.out.println("Even/Odd Bet\n" +
                        "\t1. Even\n" +
                        "\t2. Odd\n"
                );

                String evenOddInput = prompter.prompt("Select an option (1-2): ", "[1-2]", errorMessageInvalidSelection());
                betOption = evenOddInput.equals("1") ? BetType.EvenOdd.EVEN : BetType.EvenOdd.ODD;
                if (evenOddInput.equals("1")) {
                    betOption = BetType.EvenOdd.EVEN;
                } else {
                    betOption = BetType.EvenOdd.ODD;
                }

                break;

            case "5":
                betType = BetType.COLUMN;
                System.out.println("Column Bets\n" +
                        "\t1. First Column (Starts 1 - Ends 34)\n" +
                        "\t2. Second Column (Starts 2 - Ends 35)\n" +
                        "\t3. Third Column (Starts 3 - Ends 36)\n"
                );

                String columnInput = prompter.prompt("Select a column (1-3): ", "[1-3]", errorMessageInvalidSelection());
                switch (columnInput) {
                    case "1":
                        betOption = BetType.Column.COLUMN_1_ENDS_34;
                        break;
                    case "2":
                        betOption = BetType.Column.COLUMN_2_ENDS_35;
                        break;
                    case "3":
                        betOption = BetType.Column.COLUMN_3_ENDS_36;
                }
                break;

            case "6":
                betType = BetType.HIGH_LOW;
                System.out.println("High/Low Bet\n" +
                        "\t1. Low (1-18)\n" +
                        "\t2. High (19-36)\n"
                );

                String highLowInput = prompter.prompt("Select an option (1-2): ", "[1-2]", errorMessageInvalidSelection());
                if ("1".equals(highLowInput)) {
                    betOption = BetType.HighLow.LOW_1_TO_18;
                } else {
                    betOption = BetType.HighLow.HIGH_19_TO_36;
                }
        }

        /*
         * Ask player for an  amount to bet.
         */
        refreshScreen();
        chip = selectChip();

        return new Bet(betType, betOption, chip);
    }

    public Board.Chip selectChip() {
        Board.Chip selectedChip = null;

        // Build Selection Screen
        StringBuilder amountSelectionBuilder = new StringBuilder()
                .append("Select an amount to bet \n");

        Board.Chip[] chips = Board.Chip.values();
        for (int i = 0; i < chips.length; i++) {
            amountSelectionBuilder.append("\t")
                    .append(i + 1)
                    .append(" ")
                    .append(chips[i].getChip())
                    .append(" ")
                    .append(chips[i].value())
                    .append("\n");
        }

        while (true) {

            int amountIdxInput = Integer.parseInt(prompter.prompt("Select an amount (1-" + chips.length + "): ",
                    "[1-" + chips.length + "]", errorMessageInvalidSelection()));

            // Array is 0-indexed, but for user selection we started at 1
            selectedChip = chips[amountIdxInput - 1];
            double amountToValidate = selectedChip.value();

            if (amountToValidate > player.getAccountBalance()) {
                System.out.printf(colorRed("Insufficient Balance!") + " Current account balance is $%,.2f\n\n", player.getAccountBalance());
                continue;
            }

            break;
        }

        return selectedChip;
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

    public String errorMessageInvalidSelection() {
        return colorRed("Invalid Selection!") + " Please try again.\n\n";
    }

    public String errorMessageInvalidEntry() {
        return colorRed("Invalid Entry!") + " Please try again.\n\n";
    }


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void refreshScreen() {
        Console.clear();
        gameStats();
        board.display();
    }
}
