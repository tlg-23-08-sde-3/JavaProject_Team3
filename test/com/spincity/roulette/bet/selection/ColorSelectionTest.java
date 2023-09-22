package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.spincity.roulette.utils.ErrorMessages.errorMessageInvalidSelection;
import static org.junit.Assert.*;

public class ColorSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_red() {
        Prompter prompter = new Prompter(new Scanner("1"));
        ColorSelection colorSelection = new ColorSelection(prompter);
        colorSelection.select();

        assertEquals(BetType.Color.RED, colorSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_2_shouldReturn_black() {
        Prompter prompter = new Prompter(new Scanner("2"));
        ColorSelection colorSelection = new ColorSelection(prompter);
        colorSelection.select();

        assertEquals(BetType.Color.BLACK, colorSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_3_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("3"));
        ColorSelection colorSelection = new ColorSelection(prompter);
        colorSelection.select();

        assertNull(colorSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        ColorSelection colorSelection = new ColorSelection(prompter);
        colorSelection.select();

        assertNull(colorSelection.getBetOption());
    }

}