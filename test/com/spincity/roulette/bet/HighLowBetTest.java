package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighLowBetTest {

    @Test
    public void highLowBetTest_lowBets() {
        Bet bet = new Bet(BetType.HIGH_LOW, BetType.HighLow.LOW_1_TO_18, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new HighLowBet(bet);
        SpinnerNumber[] spinnerNumbers = SpinnerNumber.values();

        for (SpinnerNumber spinnerNumber : spinnerNumbers) {
            double amountWon = betCalculator.calculateWinLoss(spinnerNumber);
            if (1 <= spinnerNumber.getNumber() && spinnerNumber.getNumber() <= 18) {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 2x", 200.0, amountWon, 0.001);
            } else {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 0x", 0.0, amountWon, 0.001);
            }
        }
    }

    @Test
    public void highLowBetTest_highBets() {
        Bet bet = new Bet(BetType.HIGH_LOW, BetType.HighLow.HIGH_19_TO_36, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new HighLowBet(bet);
        SpinnerNumber[] spinnerNumbers = SpinnerNumber.values();

        for (SpinnerNumber spinnerNumber : spinnerNumbers) {
            double amountWon = betCalculator.calculateWinLoss(spinnerNumber);
            if (19 <= spinnerNumber.getNumber() && spinnerNumber.getNumber() <= 36) {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 2x", 200.0, amountWon, 0.001);
            } else {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 0x", 0.0, amountWon, 0.001);
            }
        }
    }

}
