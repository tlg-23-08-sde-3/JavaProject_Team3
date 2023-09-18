package com.spincity.roulette.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.Game;
import com.spincity.roulette.Login;
import com.spincity.roulette.Player;

import java.util.Scanner;

public class Controller {
    Login login;
    private final Prompter prompter = new Prompter(new Scanner(System.in));

    public Controller() {
        login = new Login();
    }

    public void execute() throws Exception {
        splashScreen();
        welcome();
        // Run until user selects exit at the login prompt
        while (true) {
            Player player = login.start();

            // Exit from entire application
            if (!player.wantsToPlay()) {
                break;
            }

            // Continue creating new game if user selects continue playing at the end of game screen
            while (player.wantsToPlay()) {
                Game game = new Game(player);
                game.play();
            }

        }
    }


    private void splashScreen() throws Exception {
        System.out.println("Spin City With Lights!");
        Thread.sleep(2000);
        Console.clear();
    }

    private void welcome() throws Exception {
        System.out.println("Welcome to Roulette!");
        Thread.sleep(2000);
        Console.clear();
    }


}
