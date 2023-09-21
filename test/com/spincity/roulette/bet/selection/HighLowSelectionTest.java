package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HighLowSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_low() {
        Prompter prompter = new Prompter(new Scanner("1"));
        HighLowSelection highLowSelection = new HighLowSelection(prompter);
        highLowSelection.select();

        assertEquals(BetType.HighLow.LOW_1_TO_18, highLowSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_2_shouldReturn_high() {
        Prompter prompter = new Prompter(new Scanner("2"));
        HighLowSelection highLowSelection = new HighLowSelection(prompter);
        highLowSelection.select();

        assertEquals(BetType.HighLow.HIGH_19_TO_36, highLowSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_3_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("3"));
        HighLowSelection highLowSelection = new HighLowSelection(prompter);
        highLowSelection.select();

        assertNull(highLowSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        HighLowSelection highLowSelection = new HighLowSelection(prompter);
        highLowSelection.select();

        assertNull(highLowSelection.getBetOption());
    }
}