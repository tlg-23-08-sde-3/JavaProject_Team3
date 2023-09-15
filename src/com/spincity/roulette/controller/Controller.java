package com.spincity.roulette.controller;

import com.apps.util.Console;
import com.apps.util.Prompter;
import com.spincity.roulette.Game;

import java.util.Scanner;

public class Controller {
    public void execute() throws Exception {
        splashScreen();
        welcome();
        loginScreen();
    }

    private void loginScreen() {
        // Login or SignUp
        Prompter prompter = new Prompter(new Scanner(System.in));

        String input = prompter.prompt("Enter you login id: ");

        Game game = new Game();
        game.selectBet();

        // Ask for Input based on what was selected

        // either displayBoard() or stay on loginScreen()
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
