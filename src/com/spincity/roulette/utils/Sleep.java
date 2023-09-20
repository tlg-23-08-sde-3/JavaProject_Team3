package com.spincity.roulette.utils;

public class Sleep {
    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}