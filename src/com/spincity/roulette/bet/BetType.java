package com.spincity.roulette.bet;

import com.spincity.roulette.Board.Element;

public enum BetType {
    SINGLE_NUMBER(36, "Number Bet"),
    DOZEN(3, "Dozen Bet"),
    COLUMN(3, "Column Bet"),
    COLOR(2, "Color Bet"),
    HIGH_LOW(2, "High/Low Bet"),
    EVEN_ODD(2, "Even/Odd Bet");

    private final int multiplier;
    private final String menuText;

    BetType(int multiplier, String menuText) {
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
        EVEN(Element.EVEN),
        ODD(Element.ODD);

        private final Element element;

        EvenOdd(Element element) {
            this.element = element;
        }

        public Element boardElement() {
            return element;
        }
    }

    public enum Color implements BetOption {
        RED(Element.RED),
        BLACK(Element.BLACK),
        NO_COLOR(Element.ZERO);  // for Zero

        private final Element element;

        Color(Element element) {
            this.element = element;
        }

        public Element boardElement() {
            return element;
        }
    }

    public enum Dozen implements BetOption {
        DOZEN_1_TO_12(Element.DOZEN_1_TO_12),
        DOZEN_13_TO_24(Element.DOZEN_13_TO_24),
        DOZEN_25_TO_36(Element.DOZEN_25_TO_36);

        private final Element element;

        Dozen(Element element) {
            this.element = element;
        }

        public Element boardElement() {
            return element;
        }
    }

    public enum Column implements BetOption {
        COLUMN_1_ENDS_34(Element.COLUMN_1_ENDS_34),
        COLUMN_2_ENDS_35(Element.COLUMN_2_ENDS_35),
        COLUMN_3_ENDS_36(Element.COLUMN_3_ENDS_36);

        private final Element element;

        Column(Element element) {
            this.element = element;
        }

        public Element boardElement() {
            return element;
        }
    }

    public enum HighLow implements BetOption {
        LOW_1_TO_18(Element.LOW_1_TO_18),
        HIGH_19_TO_36(Element.HIGH_19_TO_36);

        private final Element element;

        HighLow(Element element) {
            this.element = element;
        }

        public Element boardElement() {
            return element;
        }
    }

    public enum SingleNumber implements BetOption {
        ZERO(0, Element.ZERO),
        ONE(1, Element.ONE),
        TWO(2, Element.TWO),
        THREE(3, Element.THREE),
        FOUR(4, Element.FOUR),
        FIVE(5, Element.FIVE),
        SIX(6, Element.SIX),
        SEVEN(7, Element.SEVEN),
        EIGHT(8, Element.EIGHT),
        NINE(9, Element.NINE),
        TEN(10, Element.TEN),
        ELEVEN(11, Element.ELEVEN),
        TWELVE(12, Element.TWELVE),
        THIRTEEN(13, Element.THIRTEEN),
        FOURTEEN(14, Element.FOURTEEN),
        FIFTEEN(15, Element.FIFTEEN),
        SIXTEEN(16, Element.SIXTEEN),
        SEVENTEEN(17, Element.SEVENTEEN),
        EIGHTEEN(18, Element.EIGHTEEN),
        NINETEEN(19, Element.NINETEEN),
        TWENTY(20, Element.TWENTY),
        TWENTY_ONE(21, Element.TWENTY_ONE),
        TWENTY_TWO(22, Element.TWENTY_TWO),
        TWENTY_THREE(23, Element.TWENTY_THREE),
        TWENTY_FOUR(24, Element.TWENTY_FOUR),
        TWENTY_FIVE(25, Element.TWENTY_FIVE),
        TWENTY_SIX(26, Element.TWENTY_SIX),
        TWENTY_SEVEN(27, Element.TWENTY_SEVEN),
        TWENTY_EIGHT(28, Element.TWENTY_EIGHT),
        TWENTY_NINE(29, Element.TWENTY_NINE),
        THIRTY(30, Element.THIRTY),
        THIRTY_ONE(31, Element.THIRTY_ONE),
        THIRTY_TWO(32, Element.THIRTY_TWO),
        THIRTY_THREE(33, Element.THIRTY_THREE),
        THIRTY_FOUR(34, Element.THIRTY_FOUR),
        THIRTY_FIVE(35, Element.THIRTY_FIVE),
        THIRTY_SIX(36, Element.THIRTY_SIX);

        private final int value;
        private final Element element;

        SingleNumber(int value, Element element) {
            this.value = value;
            this.element = element;
        }

        public int value() {
            return value;
        }

        public Element boardElement() {
            return element;
        }
    }
}
