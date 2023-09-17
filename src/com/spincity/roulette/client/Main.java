package com.spincity.roulette.client;

import com.spincity.roulette.Bet;
import com.spincity.roulette.controller.Controller;

class Main {

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.execute();
        Bet.EvenOdd evenOdd =  Bet.EvenOdd.EVEN;

    }
}
