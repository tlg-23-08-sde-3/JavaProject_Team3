package com.spincity.roulette.account;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    @Before
    public void setUp() {
        player = new Player("Test");
    }

    @Test
    public void addAmount_shouldAddAmountToPlayerBalance() {
        player.setAccountBalance(1000.0);
        player.addAmount(100.0);
        assertEquals(1100.0, player.getAccountBalance(), 0.001);
    }

    @Test
    public void subtractAmount_shouldSubtractAmountToPlayerBalance() {
        player.setAccountBalance(1000.0);
        player.subtractAmount(100.0);
        assertEquals(900.0, player.getAccountBalance(), 0.001);
    }
}