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
    public void whenUserSelected_1_shouldReturn_red() throws Exception {
        Prompter prompter = new Prompter(new Scanner("1"));

        String colorInput = prompter.prompt("Select a color (1-2): ", "[1-2]", errorMessageInvalidSelection());
        BetType.Color colorBet = colorInput.equals("1") ? BetType.Color.RED : BetType.Color.BLACK;

        assertEquals(BetType.Color.RED, colorBet);

    }

    @Test
    public void whenUserSelected_2_shouldReturn_black() throws Exception {
        Prompter prompter = new Prompter(new Scanner("2"));

        String colorInput = prompter.prompt("Select a color (1-2): ", "[1-2]", errorMessageInvalidSelection());
        BetType.Color colorBet = colorInput.equals("1") ? BetType.Color.RED : BetType.Color.BLACK;

        assertEquals("2", colorInput);
        assertEquals(BetType.Color.BLACK, colorBet);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_3_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("3"));

        String colorInput = prompter.prompt("Select a color (1-2): ", "[1-2]", errorMessageInvalidSelection());

        assertNull(colorInput);
    }

}