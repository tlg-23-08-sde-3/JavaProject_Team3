package com.spincity.roulette;

public class Bet {
    private BetType type;
    private BetOption option;
    private double amount;

    public Bet () {

    }

    public Bet(BetType betType) {
        setType(betType);
    }

    public Bet(BetType betType, BetOption option) {
        this(betType);
        setOption(option);
    }

    public Bet(BetType betType, BetOption option, double amount) {
        this(betType, option);
        setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public static enum Column {
        NO_GROUP,   // for zero
        COLUMN_1_TO_34,
        COLUMN_2_TO_35,
        COLUMN_3_TO_36;
    }

    public static enum LowHigh {
        No_GROUP,   // for zero
        LOW_1_TO_18,
        HIGH_19_TO_36;
    }


}
