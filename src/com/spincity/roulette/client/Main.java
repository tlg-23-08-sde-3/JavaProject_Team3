package com.spincity.roulette.client;

import com.spincity.roulette.BettingCategory;
import com.spincity.roulette.controller.Controller;

class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        controller.execute();
        BettingCategory.EvenOdd evenOdd =  BettingCategory.EvenOdd.EVEN;
    }
}
