package com.spincity.roulette;

import static com.spincity.roulette.utils.ANSI.*;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.concurrent.CountDownLatch;
import javax.swing.*;
import java.util.Scanner;

public class Game {
    private Board board;
    private SpinnerNumber winningNumber;
    private BetType betType;
    private BetOption betOption;
    private double amount;
    private Player player;
    private final Prompter prompter = new Prompter(new Scanner(System.in));
    private final CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        // TODO: Remove in final version
        Account account = Account.createNewAccount("Kobi");
        Game game = new Game(account.getPlayer());
        game.play();
    }

    public Game(Player player) {
        setPlayer(player);
        board = new Board();
    }

    public void gameStats() {
        System.out.printf("Player Name: %48s Account Balance: $%,.2f\n", "Jojo", 2500.0);
    }

    public void play() {
        refreshScreen();
        Bet bet = betSelection();


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

                // Place Chips
                for (var element : Board.BoardElement.values()) {
                    try {
                        int boardNumber = Integer.parseInt(element.value());
                        if (boardNumber == singleNumberSelection) {
                            board.placeChips(element);
                            break;
                        }
                    } catch (Exception ignored) {
                        // We can ignore non-number board elements
                    }
                }

                // Update bet option
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
                        board.placeChips(Board.BoardElement.DOZEN_1_TO_12);
                        betOption = BetType.Dozen.DOZEN_1_TO_12;
                        break;
                    case "2":
                        board.placeChips(Board.BoardElement.DOZEN_13_TO_24);
                        betOption = BetType.Dozen.DOZEN_13_TO_24;
                        break;
                    case "3":
                        board.placeChips(Board.BoardElement.DOZEN_25_TO_36);
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
                    board.placeChips(Board.BoardElement.RED);
                    betOption = BetType.Color.RED;
                } else {
                    board.placeChips(Board.BoardElement.BLACK);
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
                    board.placeChips(Board.BoardElement.EVEN);
                    betOption = BetType.EvenOdd.EVEN;
                } else {
                    board.placeChips(Board.BoardElement.ODD);
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
                        board.placeChips(Board.BoardElement.COLUMN_1_ENDS_34);
                        betOption = BetType.Column.COLUMN_1_ENDS_34;
                        break;
                    case "2":
                        board.placeChips(Board.BoardElement.COLUMN_2_ENDS_35);
                        betOption = BetType.Column.COLUMN_2_ENDS_35;
                        break;
                    case "3":
                        board.placeChips(Board.BoardElement.COLUMN_3_ENDS_36);
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
                    board.placeChips(Board.BoardElement.LOW_1_TO_18);
                    betOption = BetType.HighLow.LOW_1_TO_18;
                } else {
                    board.placeChips(Board.BoardElement.HIGH_19_TO_36);
                    betOption = BetType.HighLow.HIGH_19_TO_36;
                }
        }

        /*
         * Ask player for an  amount to bet.
         */
        refreshScreen();
        while (true) {
            amount = Double.parseDouble(prompter.prompt("Enter an amount to bet: ", "[+-]?([0-9]+[.])?[0-9]+", errorMessageInvalidEntry()));

            if (amount <= 0) {
                System.out.println(colorRed("Amount must be greater than 0!") + " Please try again.\n");
                continue;
            }

            if (amount > player.getAccountBalance()) {
                System.out.printf(colorRed("Insufficient Balance!") + " Max amount you can bet is $%,.2f\n\n", player.getAccountBalance());
                continue;
            }

            break;
        }

        return new Bet(betType, betOption, amount);
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
