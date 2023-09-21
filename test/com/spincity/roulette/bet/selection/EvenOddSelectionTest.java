package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class EvenOddSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_even() {
        Prompter prompter = new Prompter(new Scanner("1"));
        EvenOddSelection evenOddSelection = new EvenOddSelection(prompter);
        evenOddSelection.select();

        assertEquals(BetType.EvenOdd.EVEN, evenOddSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_2_shouldReturn_dozen_odd() {
        Prompter prompter = new Prompter(new Scanner("2"));
        EvenOddSelection evenOddSelection = new EvenOddSelection(prompter);
        evenOddSelection.select();

        assertEquals(BetType.EvenOdd.ODD, evenOddSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_3_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("3"));
        EvenOddSelection evenOddSelection = new EvenOddSelection(prompter);
        evenOddSelection.select();

        assertNull(evenOddSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        EvenOddSelection evenOddSelection = new EvenOddSelection(prompter);
        evenOddSelection.select();

        assertNull(evenOddSelection.getBetOption());
    }

}