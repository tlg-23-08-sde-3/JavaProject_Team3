package com.spincity.roulette;

public class Player {
    private String playerName;
    private int accountId;
    private double accountBalance;
    private boolean wantsToPlay;

    public Player(String playerName) {
        setPlayerName(playerName);
        setWantsToPlay(true);
        setAccountId(0);
        setAccountBalance(2500.0); // start the player with default play money of $2500
    }

    public Player(int accountId) {
        setAccountId(accountId);
    }

    public Player(double accountBalance) {
        setAccountBalance(accountBalance);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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
}

