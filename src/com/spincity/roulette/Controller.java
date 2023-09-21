package com.spincity.roulette;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.account.Account;
import com.spincity.roulette.account.Player;
import com.spincity.roulette.utils.ANSI;

import java.util.Scanner;

import static com.apps.util.Console.pause;

public class Controller {

    private final Login login;
    private final Prompter prompter = new Prompter(new Scanner(System.in));

    public Controller() {
        login = new Login();
    }

    public void execute() throws Exception {
        welcome();

        // Run until user selects exit at the login prompt.
        boolean gameOver = false;
        while (!gameOver) {
            Player player = login.start();

            // Exit from entire application
            if (!player.wantsToPlay()) {
                gameOver = true;
                continue;
            }

            // Continue creating new game if user selects continue playing at the end of game screen
            if (player.getAccountBalance() <= 0.0) {
                prompter.prompt(ANSI.colorRed("Insufficient funds to play game!\n") + "Press enter to go back to the login screen to add funds to your account!");
            } else {
                while (player.wantsToPlay()) {
                    Game game = new Game(player);
                    game.play();
                }
            }
        }

        // Save all accounts to CSV when the application exits
        Account.saveAccountsToCsv();

    }

    private void welcome() {
        SplashScreen splashScreen = new SplashScreen("Welcome");
        splashScreen.run();
        pause(10000);
        Console.clear();
    }


}
