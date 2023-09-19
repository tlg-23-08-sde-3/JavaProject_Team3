package com.spincity.roulette.bet;

import com.spincity.roulette.Board.BoardElement;

public enum BetType {
    SINGLE_NUMBER(36, "Number Bet"),
    DOZEN(3, "Dozen Bet"),
    COLUMN(3, "Column Bet"),
    COLOR(2, "Color Bet"),
    HIGH_LOW(2, "High/Low Bet"),
    EVEN_ODD(2, "Even/Odd Bet");

    private final int multiplier;
    private final String menuText;

    BetType(int multiplier, String menuText ) {
        this.multiplier = multiplier;
        this.menuText = menuText;
    }

    public int multiplier() {
        return multiplier;
    }

    public String menuText() {
        return menuText;
    }


    public enum EvenOdd implements BetOption {
        EVEN(BoardElement.EVEN),
        ODD(BoardElement.ODD);

        private final BoardElement boardElement;

        EvenOdd(BoardElement boardElement) {
            this.boardElement = boardElement;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }

    public enum Color implements BetOption {
        RED(BoardElement.RED),
        BLACK(BoardElement.BLACK),
        NO_COLOR(BoardElement.ZERO);  // for Zero

        private final BoardElement boardElement;

        Color(BoardElement boardElement) {
            this.boardElement = boardElement;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }

    public enum Dozen implements BetOption {
        DOZEN_1_TO_12(BoardElement.DOZEN_1_TO_12),
        DOZEN_13_TO_24(BoardElement.DOZEN_13_TO_24),
        DOZEN_25_TO_36(BoardElement.DOZEN_25_TO_36);

        private final BoardElement boardElement;

        Dozen(BoardElement boardElement) {
            this.boardElement = boardElement;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }

    public enum Column implements BetOption {
        COLUMN_1_ENDS_34(BoardElement.COLUMN_1_ENDS_34),
        COLUMN_2_ENDS_35(BoardElement.COLUMN_2_ENDS_35),
        COLUMN_3_ENDS_36(BoardElement.COLUMN_3_ENDS_36);

        private final BoardElement boardElement;

        Column(BoardElement boardElement) {
            this.boardElement = boardElement;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }

    public enum HighLow implements BetOption {
        LOW_1_TO_18(BoardElement.LOW_1_TO_18),
        HIGH_19_TO_36(BoardElement.HIGH_19_TO_36);

        private final BoardElement boardElement;

        HighLow(BoardElement boardElement) {
            this.boardElement = boardElement;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }

    public enum SingleNumber implements BetOption {
        ZERO(0, BoardElement.ZERO),
        ONE(1, BoardElement.ONE),
        TWO(2, BoardElement.TWO),
        THREE(3, BoardElement.THREE),
        FOUR(4, BoardElement.FOUR),
        FIVE(5, BoardElement.FIVE),
        SIX(6, BoardElement.SIX),
        SEVEN(7, BoardElement.SEVEN),
        EIGHT(8, BoardElement.EIGHT),
        NINE(9, BoardElement.NINE),
        TEN(10, BoardElement.TEN),
        ELEVEN(11, BoardElement.ELEVEN),
        TWELVE(12, BoardElement.TWELVE),
        THIRTEEN(13, BoardElement.THIRTEEN),
        FOURTEEN(14, BoardElement.FOURTEEN),
        FIFTEEN(15, BoardElement.FIFTEEN),
        SIXTEEN(16, BoardElement.SIXTEEN),
        SEVENTEEN(17, BoardElement.SEVENTEEN),
        EIGHTEEN(18, BoardElement.EIGHTEEN),
        NINETEEN(19, BoardElement.NINETEEN),
        TWENTY(20, BoardElement.TWENTY),
        TWENTY_ONE(21, BoardElement.TWENTY_ONE),
        TWENTY_TWO(22, BoardElement.TWENTY_TWO),
        TWENTY_THREE(23, BoardElement.TWENTY_THREE),
        TWENTY_FOUR(24, BoardElement.TWENTY_FOUR),
        TWENTY_FIVE(25, BoardElement.TWENTY_FIVE),
        TWENTY_SIX(26, BoardElement.TWENTY_SIX),
        TWENTY_SEVEN(27, BoardElement.TWENTY_SEVEN),
        TWENTY_EIGHT(28, BoardElement.TWENTY_EIGHT),
        TWENTY_NINE(29, BoardElement.TWENTY_NINE),
        THIRTY(30, BoardElement.THIRTY),
        THIRTY_ONE(31, BoardElement.THIRTY_ONE),
        THIRTY_TWO(32, BoardElement.THIRTY_TWO),
        THIRTY_THREE(33, BoardElement.THIRTY_THREE),
        THIRTY_FOUR(34, BoardElement.THIRTY_FOUR),
        THIRTY_FIVE(35, BoardElement.THIRTY_FIVE),
        THIRTY_SIX(36, BoardElement.THIRTY_SIX);

        private final int value;
        private final BoardElement boardElement;

        SingleNumber(int value, BoardElement boardElement) {
            this.value = value;
            this.boardElement = boardElement;
        }

        public int value() {
            return value;
        }

        public BoardElement boardElement() {
            return boardElement;
        }
    }
}
