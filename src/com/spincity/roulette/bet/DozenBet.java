package com.spincity.roulette.bet;

import com.spincity.roulette.Board;
import com.spincity.roulette.spinner.SpinnerNumber;
import com.spincity.roulette.bet.BetType.Dozen;

import static com.spincity.roulette.bet.BetType.Dozen.*;

public class DozenBet implements BetCalculator {
    private Bet bet;

    public DozenBet(Bet bet) {
        setBet(bet);
    }

    public static void main(String[] args) {
        DozenBet dozenBet = new DozenBet(new Bet(BetType.DOZEN , DOZEN_13_TO_24, Board.Chip.CHIP_100));
        double result = dozenBet.calculateWinLoss(SpinnerNumber.FIFTEEN);
        System.out.println(result);
        }

    @Override
    public double calculateWinLoss(SpinnerNumber spinnerNumber) {
        int number = spinnerNumber.getNumber();
        BetOption dozenOption = bet.getOption();

        // Check if the spinner number is "0"
        if (number == 0) {
            return 0.0;
        }

        // Determine which dozen the spinner number belongs to
        int dozen;

        if (number >= 1 && number <= 12) {
            dozen = 0;
        } else if (number >= 13 && number <= 24) {
            dozen = 1;
        } else {
            dozen = 2;
        }

        // Check for the match
        if (bet.getOption() == Dozen.values()[dozen]) {
            return bet.getChip().value() * bet.getType().multiplier();
        }

        // Return 0 if not a win
        return 0.0;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
}
