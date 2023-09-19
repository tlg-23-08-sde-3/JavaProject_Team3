package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColumnBetTest {

    // Bet : Column 1 , Spinner : 1
    @Test
    public void whenColumnOne_isWin () {
        Bet bet = new Bet(BetType.COLUMN, BetType.Column.COLUMN_1_ENDS_34, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.ONE;
        ColumnBet columnBet = new ColumnBet(bet);
        double result = columnBet.calculateWinLoss(spinnerNumber);
        assertEquals(300.0, result, 0.001);
    }

    // Bet : Column 2 , Spinner : 2
    @Test
    public void whenColumnTwo_isWin () {
        Bet bet = new Bet(BetType.COLUMN, BetType.Column.COLUMN_1_ENDS_34, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.TWO;
        ColumnBet columnBet = new ColumnBet(bet);
        double result = columnBet.calculateWinLoss(spinnerNumber);
        assertEquals(300.0, result, 0.001);
    }
}