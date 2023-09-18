package com.spincity.roulette.controller;

import com.apps.util.Console;
import com.spincity.roulette.Login;

public class Controller {
    public void execute() throws Exception {
        splashScreen();
        welcome();

        Login login = new Login();
        Login.start();

    }


        String input = prompter.prompt("Enter you login id: ");

        Game game = new Game();
        // TODO: returns whether user wants to continue playing
        game.play();



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
