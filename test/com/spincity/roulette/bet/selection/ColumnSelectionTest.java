package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ColumnSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_1_34() {
        Prompter prompter = new Prompter(new Scanner("1"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertEquals(BetType.Column.COLUMN_1_ENDS_34, columnSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_2_shouldReturn_2_35() {
        Prompter prompter = new Prompter(new Scanner("2"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertEquals(BetType.Column.COLUMN_2_ENDS_35, columnSelection.getBetOption());
    }

    @Test
    public void whenUserSelected_3_shouldReturn_3_36() {
        Prompter prompter = new Prompter(new Scanner("3"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertEquals(BetType.Column.COLUMN_3_ENDS_36, columnSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_4_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("4"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertNull(columnSelection.getBetOption());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_invalidInput() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertNull(columnSelection.getBetOption());
    }

}