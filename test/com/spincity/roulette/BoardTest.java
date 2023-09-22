package com.spincity.roulette;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    Board board;

    @Before
    public void init() {
        board = new Board();
    }

    @Test
    public void placeChips_shouldUpdateBoardState() {
        Board.Chip testChip = Board.Chip.CHIP_100;
        Board.Element testElement = Board.Element.ONE;
        board.placeChips(testElement, testChip);

        for (var entries : board.getBoardState().entrySet()) {
            Board.Element boardElement = entries.getKey();
            Board.Chip boardChip = entries.getValue();

            if (boardElement == testElement) {
                assertSame("BoardElement: " + boardElement + "should be equal to " + testChip, boardChip, testChip);
            } else {
                assertNotSame("BoardElement: " + boardElement + " should be null ", boardChip, testChip);
            }
        }
    }

    @Test
    public void showElem_shouldReturnStringContainingElementAndChip_whenChipIsPresent() {

        Board.Chip testChip = Board.Chip.CHIP_100;
        Board.Element testElement = Board.Element.TWO;
        board.placeChips(testElement, testChip);

        String result = board.showElem(testElement);
        String expectedString = testElement + Board.Chip.CHIP_100.getChip();

        assertEquals(result, expectedString);
    }

    @Test
    public void showElem_shouldReturnStringContainingElementAndEmptyString_whenChipIsNotPresent() {
        Board.Element testElement = Board.Element.THREE;
        String result = board.showElem(testElement);
        String expectedString = testElement + " ";
        assertEquals(result, expectedString);
    }

}