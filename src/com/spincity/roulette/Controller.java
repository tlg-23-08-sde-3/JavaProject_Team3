package com.spincity.roulette;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.Game;
import com.spincity.roulette.account.Login;
import com.spincity.roulette.account.Player;
import com.spincity.roulette.SplashScreen;

import java.util.Scanner;

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
            while (player.wantsToPlay()) {
                Game game = new Game(player);
                game.play();
            }

        }
    }

    private void welcome() throws Exception {
        splashScreen = new SplashScreen("Splash");
        splashScreen.run();
        Thread.sleep(5000);
        splashScreen = new SplashScreen("Welcome");
        splashScreen.run();
        Thread.sleep(5000);
        Console.clear();
    }


}
