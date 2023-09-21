package com.spincity.roulette.bet;

import static org.junit.Assert.*;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Test;

public class SingleNumberBetTest {
    @Test
    public void singleNumberTest() {
        Bet bet = new Bet(BetType.SINGLE_NUMBER, Board.Chip.CHIP_100);

        for (BetType.SingleNumber singleNumber : BetType.SingleNumber.values()) {
            int selectedNumber = singleNumber.value();
            bet.setOption(singleNumber);
            BetCalculator betCalculator = new SingleNumberBet(bet);

            for (SpinnerNumber spinnerNumber : SpinnerNumber.values()) {
                int winnerNumber = spinnerNumber.getNumber();
                double amountWon = betCalculator.calculateWinLoss(spinnerNumber);

                if (selectedNumber == winnerNumber) {
                    assertEquals("Selected Number: " + selectedNumber + " -> Spinner Number: " + winnerNumber + " should return 36x",
                            3600.0, amountWon, 0.001);
                } else {
                    assertEquals("Selected Number: " + selectedNumber + " -> Spinner Number: " + winnerNumber + " should return 0x",
                            0.0, amountWon, 0.001);
                }
            }
        }
    }
}
