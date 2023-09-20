package com.spincity.roulette;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.account.Login;
import com.spincity.roulette.account.Player;
import com.spincity.roulette.utils.ANSI;

import java.util.Scanner;

import static com.apps.util.Console.pause;

public class Controller {

    Login login;
    private SplashScreen splashScreen;
    private final Prompter prompter = new Prompter(new Scanner(System.in));

    public Controller() {
        login = new Login();
    }

    public void execute() throws Exception {
        welcome();
        // Run until user selects exit at the login prompt
        while (true) {
            Player player = login.start();

            // Exit from entire application
            if (!player.wantsToPlay()) {
                System.exit(0);
            }

            // Continue creating new game if user selects continue playing at the end of game screen
            if (player.getAccountBalance() < 0) {
               prompter.prompt(ANSI.colorRed("Insufficient funds to play game!\n") + "Press enter to go back to the login screen to add funds to your account!");
            }

            while (player.wantsToPlay()) {
                Game game = new Game(player);
                game.play();
            }

        }
    }

    private void welcome() {
        splashScreen = new SplashScreen("Welcome");
        splashScreen.run();
        pause(10000);
        Console.clear();
    }


}
