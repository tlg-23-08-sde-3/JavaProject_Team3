package com.spincity.roulette;

import static com.spincity.roulette.Board.BoardElement.*;

import com.apps.util.Console;
import com.spincity.roulette.utils.ANSI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static final String defaultForeground = ANSI.Color.OFF_WHITE.toString();
    private static final String defaultBackground = ANSI.BackgroundColor.GREEN.toString();
    //    private static final String defaultBackground = "\u001B[48;5;28m";
    private static final String chip = ANSI.Color.BRIGHT_YELLOW + "●" + defaultForeground;

    // State of board values: Not Selected = " ", Selected = "@";
    private final Map<BoardElement, String> boardState;

    public static void main(String[] args) {
        // TODO: remove in the final version
        // This Main Method is for Testing Only
        Board board = new Board();
        board.placeChips(TWELVE);
        board.placeChips(THIRTY_FOUR);
        board.placeChips(SECOND_COLUMN);
        board.placeChips(RED);
        board.display();

    }

    public Board() {
        boardState = new HashMap<>();

        // Initialize boardState with all elements — set initial state to be empty
        for (BoardElement boardElement : BoardElement.values()) {
            boardState.put(boardElement, " ");
        }
    }

    public void display() {

        List<String> boardLines = new ArrayList<>();
        boardLines.add("                                                                                                  ");
        boardLines.add("     /‾|‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾‾‾|");
        boardLines.add("    /  |  " + showElem(THREE) + " |  " + showElem(SIX) + " |  " + showElem(NINE) + " |  " + showElem(TWELVE) + " |  " + showElem(FIFTEEN) + " |  " + showElem(EIGHTEEN) + " |  " + showElem(TWENTY_ONE) + " |  " + showElem(TWENTY_FOUR) + " |  " + showElem(TWENTY_SEVEN) + " |  " + showElem(THIRTY) + " |  " + showElem(THIRTY_THREE) + " |  " + showElem(THIRTY_SIX) + " |  " + showElem(THIRD_COLUMN) + " |");
        boardLines.add("   /   |     |     |     |      |      |      |      |      |      |      |      |      |        |");
        boardLines.add("  /    |‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾‾‾|");
        boardLines.add(" |  " + showElem(ZERO) + " |  " + showElem(TWO) + " |  " + showElem(FIVE) + " |  " + showElem(EIGHT) + " |  " + showElem(ELEVEN) + " |  " + showElem(FOURTEEN) + " |  " + showElem(SEVENTEEN) + " |  " + showElem(TWENTY) + " |  " + showElem(TWENTY_THREE) + " |  " + showElem(TWENTY_SIX) + " |  " + showElem(TWENTY_NINE) + " |  " + showElem(THIRTY_TWO) + " |  " + showElem(THIRTY_FIVE) + " |  " + showElem(SECOND_COLUMN) + " |");
        boardLines.add("  \\    |     |     |     |      |      |      |      |      |      |      |      |      |        |");
        boardLines.add("   \\   |‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾|‾‾‾‾‾‾‾‾|");
        boardLines.add("    \\  |  " + showElem(ONE) + " |  " + showElem(FOUR) + " |  " + showElem(SEVEN) + " |  " + showElem(TEN) + " |  " + showElem(THIRTEEN) + " |  " + showElem(SIXTEEN) + " |  " + showElem(NINETEEN) + " |  " + showElem(TWENTY_TWO) + " |  " + showElem(TWENTY_FIVE) + " |  " + showElem(TWENTY_EIGHT) + " |  " + showElem(THIRTY_ONE) + " |  " + showElem(THIRTY_FOUR) + " |  " + showElem(FIRST_COLUMN) + " |");
        boardLines.add("     \\_|     |     |     |      |      |      |      |      |      |      |      |      |        |");
        boardLines.add("       |‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾ ");
        boardLines.add("       |         " + showElem(DOZEN_1_TO_12) + "        |          " + showElem(DOZEN_13_TO_24) + "          |         " + showElem(DOZEN_25_TO_36) + "           |         ");
        boardLines.add("       |                        |                           |                           |         ");
        boardLines.add("       |‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾|‾‾‾‾‾‾‾‾‾‾‾‾‾|         ");
        boardLines.add("       |  " + showElem(ONE_TO_18) + " |    " + showElem(EVEN) + "   |     " + showElem(RED) + "    |    " + showElem(BLACK) + "   |     " + showElem(ODD) + "    |  " + showElem(NINETEEN_TO_36) + "  |         ");
        boardLines.add("       |           |            |             |             |             |             |         ");
        boardLines.add("        ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾          ");
        boardLines.add("                                                                                                  ");


        StringBuilder boardBuilder = new StringBuilder();

        // Add all lines to the Board
        for (String boardLine : boardLines) {
            boardBuilder
                    .append(defaultBackground)
                    .append(defaultForeground)
                    .append(" ") // Space before each line
                    .append(boardLine)
                    .append("  ") // Space after each line
                    .append(ANSI.Color.RESET)
                    .append("\n");
        }

        System.out.println(boardBuilder);
    }

    public void placeChips(BoardElement boardElement) {
        boardState.put(boardElement, chip);
    }

    // Shows the Element + Element's Chip (if user selected it)
    private String showElem(BoardElement boardElement) {
        return boardElement + boardState.get(boardElement);
    }

    // Remove all chips from the board
    private void resetBoard() {
        boardState.replaceAll((k, v) -> " ");
    }

    // Enum that represents element of the board.
    public static enum BoardElement {
        ZERO("0", ANSI.Color.WHITE),
        ONE("1", ANSI.Color.RED),
        TWO("2", ANSI.Color.BLACK),
        THREE("3", ANSI.Color.RED),
        FOUR("4", ANSI.Color.BLACK),
        FIVE("5", ANSI.Color.RED),
        SIX("6", ANSI.Color.BLACK),
        SEVEN("7", ANSI.Color.RED),
        EIGHT("8", ANSI.Color.BLACK),
        NINE("9", ANSI.Color.RED),
        TEN("10", ANSI.Color.BLACK),
        ELEVEN("11", ANSI.Color.BLACK),
        TWELVE("12", ANSI.Color.RED),
        THIRTEEN("13", ANSI.Color.BLACK),
        FOURTEEN("14", ANSI.Color.RED),
        FIFTEEN("15", ANSI.Color.BLACK),
        SIXTEEN("16", ANSI.Color.RED),
        SEVENTEEN("17", ANSI.Color.BLACK),
        EIGHTEEN("18", ANSI.Color.RED),
        NINETEEN("19", ANSI.Color.RED),
        TWENTY("20", ANSI.Color.BLACK),
        TWENTY_ONE("21", ANSI.Color.RED),
        TWENTY_TWO("22", ANSI.Color.BLACK),
        TWENTY_THREE("23", ANSI.Color.RED),
        TWENTY_FOUR("24", ANSI.Color.BLACK),
        TWENTY_FIVE("25", ANSI.Color.RED),
        TWENTY_SIX("26", ANSI.Color.BLACK),
        TWENTY_SEVEN("27", ANSI.Color.RED),
        TWENTY_EIGHT("28", ANSI.Color.BLACK),
        TWENTY_NINE("29", ANSI.Color.BLACK),
        THIRTY("30", ANSI.Color.RED),
        THIRTY_ONE("31", ANSI.Color.BLACK),
        THIRTY_TWO("32", ANSI.Color.RED),
        THIRTY_THREE("33", ANSI.Color.BLACK),
        THIRTY_FOUR("34", ANSI.Color.RED),
        THIRTY_FIVE("35", ANSI.Color.BLACK),
        THIRTY_SIX("36", ANSI.Color.RED),
        FIRST_COLUMN("Line 1", ANSI.Color.WHITE, "2To1"),
        SECOND_COLUMN("Line 2", ANSI.Color.WHITE, "2To1"),
        THIRD_COLUMN("Line 3", ANSI.Color.WHITE, "2To1"),
        DOZEN_1_TO_12("1st 12", ANSI.Color.WHITE),
        DOZEN_13_TO_24("2nd 12", ANSI.Color.WHITE),
        DOZEN_25_TO_36("3rd 12", ANSI.Color.WHITE),
        ONE_TO_18("1 to 18", ANSI.Color.WHITE),
        NINETEEN_TO_36("19 to 36", ANSI.Color.WHITE),
        EVEN("EVEN", ANSI.Color.WHITE),
        ODD("ODD", ANSI.Color.WHITE),
        RED("RED", ANSI.Color.RED),
        BLACK("BLACK", ANSI.Color.BLACK);

        private final String value;
        private final ANSI.Color color;
        // For Column Bets — The display value for all Column is "2To1", so this field is used just on them.
        private String displayValue; // If display value on the board is different text than actual value

        BoardElement(String value, ANSI.Color color) {
            this.value = value;
            this.color = color;
        }

        BoardElement(String value, ANSI.Color color, String displayValue) {
            this(value, color);
            this.displayValue = displayValue;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            String valueToReturn = displayValue == null ? value : displayValue;
            return color + valueToReturn + defaultForeground;
        }
    }

}
