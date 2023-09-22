package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvenOddBetTest {


    // Bet : Odd , Spinner : 2
    @Test
    public void whenOddBet_isLost() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.ODD, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.TWO;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(0.0, result, 0.001);
    }

    // Bet : Odd , Spinner : 1
    @Test
    public void whenOddBet_isWin() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.ODD, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.ONE;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(200.0, result, 0.001);
    }

    // Bet : Even , Spinner : 1
    @Test
    public void whenEvenBet_isLost() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.EVEN, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.ONE;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(0.0, result, 0.001);
    }

    // Bet : Even , Spinner : 2
    @Test
    public void whenEvenBet_isWin() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.EVEN, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.TWO;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(200.0, result, 0.001);
    }

    // Bet : Even , Spinner : 0
    @Test
    public void whenBet_isEven_andSpinnerZero_isLost() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.EVEN, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.ZERO;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(0.0, result, 0.001);
    }

    // Bet : Odd , Spinner : 0
    @Test
    public void whenBet_isOdd_andSpinnerZero_isLost() {
        Bet bet = new Bet(BetType.EVEN_ODD, BetType.EvenOdd.ODD, Board.Chip.CHIP_100);
        SpinnerNumber spinnerNumber = SpinnerNumber.ZERO;
        EvenOddBet evenOddBet = new EvenOddBet(bet);
        double result = evenOddBet.calculateWinLoss(spinnerNumber);
        assertEquals(0.0, result, 0.001);
    }

}