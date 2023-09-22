package com.spincity.roulette.account;

public class Player {
    private String name;
    private double accountBalance;
    private boolean wantsToPlay;

    public Player(String name) {
        setName(name);
        setWantsToPlay(true);
        setAccountBalance(2500.0); // start the player with default play money of $2500
    }

    public Player(String Name, double accountBalance) {
        setName(Name);
        setAccountBalance(accountBalance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean wantsToPlay() {
        return wantsToPlay;
    }

    public void setWantsToPlay(boolean wantsToPlay) {
        this.wantsToPlay = wantsToPlay;
    }

    public void addAmount(double amount) {
        setAccountBalance(this.getAccountBalance() + amount);
    }

    public void subtractAmount(double amount) {
        setAccountBalance(this.getAccountBalance() - amount);
    }

}

