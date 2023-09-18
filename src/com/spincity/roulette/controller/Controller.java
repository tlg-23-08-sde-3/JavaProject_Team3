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


//        Game game = new Game();
//        game.selectBet();



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
