package com.spincity.roulette;

public class Bet {
    private BetType type;
    private BetOption option;
    private Board.Chip chip;

    public Bet () {

    }

    public Bet(BetType betType) {
        setType(betType);
    }

    public Bet(BetType betType, BetOption option) {
        this(betType);
        setOption(option);
    }

    public Bet(BetType betType, BetOption option, Board.Chip chip) {
        this(betType, option);
        setChip(chip);
    }

    public Board.Chip getChip() {
        return chip;
    }

    public void setChip(Board.Chip chip) {
        this.chip = chip;
    }

    public BetType getType() {
        return type;
    }

    public void setType(BetType type) {
        this.type = type;
    }

    public BetOption getOption() {
        return option;
    }

    public void setOption(BetOption option) {
        this.option = option;
    }


}
