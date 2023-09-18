package com.spincity.roulette.client;

import com.spincity.roulette.BetType;
import com.spincity.roulette.controller.Controller;

class Main {

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.execute();
        BetType.EvenOdd evenOdd =  BetType.EvenOdd.EVEN;

    }
}
