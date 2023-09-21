package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DozenSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_dozen_1_to_12() {
        Prompter prompter = new Prompter(new Scanner("1"));
        DozenSelection dozenSelection = new DozenSelection(prompter);
        dozenSelection.select();

        assertEquals(BetType.Dozen.DOZEN_1_TO_12, dozenSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_2_shouldReturn_dozen_13_to_24() {
        Prompter prompter = new Prompter(new Scanner("2"));
        DozenSelection dozenSelection = new DozenSelection(prompter);
        dozenSelection.select();

        assertEquals(BetType.Dozen.DOZEN_13_TO_24, dozenSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_3_shouldReturn_dozen_25_to_36() {
        Prompter prompter = new Prompter(new Scanner("3"));
        DozenSelection dozenSelection = new DozenSelection(prompter);
        dozenSelection.select();

        assertEquals(BetType.Dozen.DOZEN_25_TO_36, dozenSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_4_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("4"));
        DozenSelection dozenSelection = new DozenSelection(prompter);
        dozenSelection.select();

        assertNull(dozenSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        DozenSelection dozenSelection = new DozenSelection(prompter);
        dozenSelection.select();

        assertNull(dozenSelection.getBetOption());
    }

}