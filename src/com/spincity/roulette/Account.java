package com.spincity.roulette;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private static int nextAccountId = 1001;
    private int accountId;
    private Player player;

    // Account data will be stored in Hashmap
    private static Map<Integer, Account> accountMap = new HashMap<>();

    private Account(int accountId, Player player) {
        setAccountId(accountId);
        setPlayer(player);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAccountId() {
        return accountId;
    }

    public Player getPlayer() {
        return player;
    }

    public static Account getAccount(int accountId) {
        return accountMap.get(accountId);
    }

    // Create New account with account ID starting with 1001 and increment for subsequent ones
    public static Account createNewAccount(String playerName) {
        Player player = new Player(playerName);
        Account account = new Account(nextAccountId++, player);
        accountMap.put(account.getAccountId(), account);
        return account;
    }
}
