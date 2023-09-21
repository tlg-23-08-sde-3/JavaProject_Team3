package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ColorBetTest {

    @Test
        public void colorBetCalculator_returns2xWhenUserSelectedRedColor_spinnerPickedRedColorNumber() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.RED, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.ONE);
        assertEquals(200.0, amountWon, 0.001);
    }

    @Test
        public void colorBetCalculator_returns0xWhenUserSelectedRedColor_spinnerPickedBlackColorNumber() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.RED, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.TWO);
        assertEquals(0.0, amountWon, 0.001);
    }

    @Test
        public void colorBetCalculator_returns2xWhenUserSelectedBlackColor_spinnerPickedBlackColorNumber() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.BLACK, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.TWO);
        assertEquals(200.0, amountWon, 0.001);
    }

    @Test
        public void colorBetCalculator_returns0xWhenUserSelectedBlackColor_spinnerPickedRedColorNumber() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.BLACK, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.ONE);
        assertEquals(0.0, amountWon, 0.001);
    }

    @Test
    public void colorBetCalculator_returns0xWhenUserSelectedRedColor_spinnerPickedZero() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.RED, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.ZERO);
        assertEquals(0.0, amountWon, 0.001);
    }

    @Test
    public void colorBetCalculator_returns0xWhenUserSelectedBlackColor_spinnerPickedZero() {
        Bet bet = new Bet(BetType.COLOR, BetType.Color.BLACK, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new ColorBet(bet);
        double amountWon = betCalculator.calculateWinLoss(SpinnerNumber.ZERO);
        assertEquals(0.0, amountWon, 0.001);
    }
}