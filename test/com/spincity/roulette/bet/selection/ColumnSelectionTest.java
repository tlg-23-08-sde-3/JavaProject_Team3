package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;
public class ColumnSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_red() throws Exception {
        Prompter prompter = new Prompter(new Scanner("1\n"));
        ColumnSelection columnSelection = new ColumnSelection(prompter);
        columnSelection.select();

        assertEquals(BetType.Column.COLUMN_1_ENDS_34, columnSelection.getBetOption());
    }

}