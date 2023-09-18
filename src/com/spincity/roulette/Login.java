package com.spincity.roulette;

import com.apps.util.Console;
import com.apps.util.Prompter;

import java.util.Scanner;

public class Login {
    private static Account account;

    public Login() {
        this.account = null;
    }

    public Player start() {
        Prompter prompter = new Prompter(new Scanner(System.in));
        Console.clear();
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("W E L C O M E   T O   T H E   G A M E");
        System.out.println("-------------------------------------");
        System.out.println();

        int choice;
        do {
            System.out.println();
            System.out.println("=======================");
            System.out.println("CHOOSE THE RIGHT OPTION");
            System.out.println("=======================");
            System.out.println();
            System.out.println("1. Login to existing account");
            System.out.println("2. Create new account");
            System.out.println("3. Exit the Game");
            System.out.println();
            choice = Integer.parseInt(prompter.prompt("Enter your choice:" , "(1|2|3)", "\nInvalid choice. Please select 1,2 or 3.\n"));

            switch (choice) {
                case 1:
                    Console.clear();
                    System.out.println();
                    int accountId = Integer.parseInt(prompter.prompt("Enter your account ID: ", "\\d{4}" , "\nPlease enter your 4 digit account ID\n" ));
                    account = Account.getAccount(accountId);
                    if (account == null) {
                        System.out.println();
                        System.out.println("Account not found.");
                        System.out.println();
                    } else {
                        Console.clear();
                        account.getPlayer().setWantsToPlay(true);
                        System.out.println();
                        System.out.println("Welcome back, " + account.getPlayer().getPlayerName() + "!");
                        System.out.println("Your account balance is: $" + account.getPlayer().getAccountBalance() );
                        System.out.println();
                    }
                    break;
                case 2:
                    Console.clear();
                    System.out.println();
                    System.out.println("==================");
                    System.out.println("CREATE NEW ACCOUNT");
                    System.out.println("==================");
                    System.out.println();
                    String playerName = prompter.prompt("Enter your player name: ", "[A-Za-z]+", "\nProvide a valid name\n");
                    int age = Integer.parseInt(prompter.prompt("Enter your age: ", "\\d{1,2}" , "\nAge is not valid to enter the game\n" ));
                    if (age < 21) {
                        System.out.println();
                        System.out.println("You must be at least 21 years old to play.");
                        System.out.println();
                    } else {
                        account = Account.createNewAccount(playerName);
                        System.out.println();
                        System.out.println("Account created! Your account ID is: " + account.getAccountId());
                        prompter.prompt("Take note of your Account ID and then press enter to continue...");
                    }
                    break;
                case 3:
                    if (account == null) {
                        System.exit(0);
                    } else {
                        account.getPlayer().setWantsToPlay(false);
                    }
                    break;
                default:
                    System.out.println( );
                    System.out.println("Invalid choice. Please select 1,2 or 3.");
                    break;
            }
        } while (account == null);

        return account.getPlayer();
    }
}
