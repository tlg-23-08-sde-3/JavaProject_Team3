package com.spincity.roulette.bet;

import com.spincity.roulette.Board;

/*
 * Used for grouping all bet options enum types.
 * This way instead of referencing specific bet option enum, we can just refer to the interface.
 * Code to the interface, and not the implementation!
 */
public interface BetOption {
    public Board.Element boardElement();
}
