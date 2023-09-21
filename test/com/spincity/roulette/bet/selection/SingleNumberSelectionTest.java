package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class SingleNumberSelectionTest {

    @Test
    public void whenUserSelected_int_1_TO_36_shouldReturn_corresponding_value() {
        int startNumber = 0;
        for (BetType.SingleNumber singleNumber : BetType.SingleNumber.values()) {
            Prompter prompter = new Prompter(new Scanner(String.valueOf(startNumber)));
            SingleNumberSelection singleNumberSelection = new SingleNumberSelection(prompter);
            singleNumberSelection.select();
            System.out.println(singleNumber);
            startNumber++;
            assertEquals(singleNumber, singleNumberSelection.getBetOption());
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_37_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("37"));
        SingleNumberSelection singleNumberSelection = new SingleNumberSelection(prompter);
        singleNumberSelection.select();

        assertNull(singleNumberSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        SingleNumberSelection singleNumberSelection = new SingleNumberSelection(prompter);
        singleNumberSelection.select();

        assertNull(singleNumberSelection.getBetOption());
    }

}