package com.spincity.roulette.bet.selection;

import com.apps.util.Prompter;
import com.spincity.roulette.Board;
import com.spincity.roulette.account.Player;
import com.spincity.roulette.bet.BetType;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class BetSelectionTest {

    @Test
    public void whenUserSelected_1_shouldReturn_singleNumberBet() {
        Prompter prompter = new Prompter(new Scanner("1"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.SINGLE_NUMBER, betType);
    }

    @Test
    public void whenUserSelected_2_shouldReturn_dozenBet() {
        Prompter prompter = new Prompter(new Scanner("2"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.DOZEN, betType);
    }

    @Test
    public void whenUserSelected_3_shouldReturn_columnBet() {
        Prompter prompter = new Prompter(new Scanner("3"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.COLUMN, betType);
    }

    @Test
    public void whenUserSelected_4_shouldReturn_colorBet() {
        Prompter prompter = new Prompter(new Scanner("4"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.COLOR, betType);
    }

    @Test
    public void whenUserSelected_5_shouldReturn_highLowBet() {
        Prompter prompter = new Prompter(new Scanner("5"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.HIGH_LOW, betType);
    }

    @Test
    public void whenUserSelected_6_shouldReturn_evenOddBet() {
        Prompter prompter = new Prompter(new Scanner("6"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertEquals(BetType.EVEN_ODD, betType);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_7_shouldReturn_invalidBetType() {
        Prompter prompter = new Prompter(new Scanner("7"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertNull(betType);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidBetType() {
        Prompter prompter = new Prompter(new Scanner("abc"));
        BetSelection betSelection = new BetSelection(prompter);
        BetType betType = betSelection.betTypeSelection();
        assertNull(betType);
    }

    @Test
    public void whenUserSelected_1_shouldReturn_1DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("1"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_1, chip);
    }

    @Test
    public void whenUserSelected_2_shouldReturn_5DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("2"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_5, chip);
    }

    @Test
    public void whenUserSelected_3_shouldReturn_10DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("3"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_10, chip);
    }

    @Test
    public void whenUserSelected_4_shouldReturn_25DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("4"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_25, chip);
    }

    @Test
    public void whenUserSelected_5_shouldReturn_100DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("5"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_100, chip);
    }

    @Test
    public void whenUserSelected_6_shouldReturn_500DollarChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(500.0);
        Prompter prompter = new Prompter(new Scanner("6"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertEquals(Board.Chip.CHIP_500, chip);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_6_butNotEnoughBalance_shouldReturn_Invalid() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("6"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertNull(chip);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_7_shouldReturn_invalidChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("7"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertNull(chip);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenUserSelected_abc_shouldReturn_invalidChip() {
        Player player = new Player("Tester");
        player.setAccountBalance(100.0);
        Prompter prompter = new Prompter(new Scanner("abc"));
        BetSelection betSelection = new BetSelection(prompter);
        Board.Chip chip = betSelection.selectChip(player);
        assertNull(chip);
    }
}