package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DozenBetTest {

    @Test
    public void dozenBetCalculator_1stDozen() {
        Bet bet = new Bet(BetType.DOZEN, BetType.Dozen.DOZEN_1_TO_12, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new DozenBet(bet);
        SpinnerNumber[] spinnerNumbers = SpinnerNumber.values();

        for (SpinnerNumber spinnerNumber : spinnerNumbers) {
            double amountWon = betCalculator.calculateWinLoss(spinnerNumber);
            if (1 <= spinnerNumber.getNumber() && spinnerNumber.getNumber() <= 12) {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 3x", 300.0, amountWon, 0.001);
            } else {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 0x", 0.0, amountWon, 0.001);
            }
        }
    }

    @Test
    public void dozenBetCalculator_2stDozen() {
        Bet bet = new Bet(BetType.DOZEN, BetType.Dozen.DOZEN_13_TO_24, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new DozenBet(bet);
        SpinnerNumber[] spinnerNumbers = SpinnerNumber.values();

        for (SpinnerNumber spinnerNumber : spinnerNumbers) {
            double amountWon = betCalculator.calculateWinLoss(spinnerNumber);
            if (13 <= spinnerNumber.getNumber() && spinnerNumber.getNumber() <= 24) {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 3x", 300.0, amountWon, 0.001);
            } else {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 0x", 0.0, amountWon, 0.001);
            }
        }
    }

    @Test
    public void dozenBetCalculator_3rdDozen() {
        Bet bet = new Bet(BetType.DOZEN, BetType.Dozen.DOZEN_25_TO_36, Board.Chip.CHIP_100);
        BetCalculator betCalculator = new DozenBet(bet);
        SpinnerNumber[] spinnerNumbers = SpinnerNumber.values();

        for (SpinnerNumber spinnerNumber : spinnerNumbers) {
            double amountWon = betCalculator.calculateWinLoss(spinnerNumber);
            if (25 <= spinnerNumber.getNumber() && spinnerNumber.getNumber() <= 36) {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 3x", 300.0, amountWon, 0.001);
            } else {
                assertEquals("SpinnerNumber " + spinnerNumber.getNumber() + " should return 0x", 0.0, amountWon, 0.001);
            }
        }
    }
}