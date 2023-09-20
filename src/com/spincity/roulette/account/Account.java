package com.spincity.roulette.account;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Account {
    private static int nextAccountId = 1001;
    private static final String CSV_PATH = "./data/accounts.csv";
    private int accountId;
    private Player player;

    // Account data will be stored in Hashmap
    private static final Map<Integer, Account> accountMap = new TreeMap<>();

    static {
        if (Files.exists(Path.of(CSV_PATH))) {
            int lastAccountID = 1001;

            try {
                List<String> lines = Files.readAllLines(Path.of(CSV_PATH));

                for (String line : lines) {
                    String[] accountInfo = line.split(",");
                    int accountId = Integer.parseInt(accountInfo[0]);
                    String playerName = accountInfo[1];
                    double accountBalance = Double.parseDouble(accountInfo[2]);

                    Player player = new Player(playerName, accountBalance);
                    Account account = new Account(accountId, player);
                    accountMap.put(accountId, account);
                    lastAccountID = accountId;

                    // Set next account ID for new users (1 + lastAccountID in the CSV)
                    Account.nextAccountId = lastAccountID + 1;
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private Account(int accountId, Player player) {
        setAccountId(accountId);
        setPlayer(player);
    }

    // Create New account with account ID starting with 1001 and increment for subsequent ones
    public static Account createNewAccount(String playerName) {
        Player player = new Player(playerName);
        Account account = new Account(nextAccountId++, player);
        accountMap.put(account.getAccountId(), account);
        Account.saveAccountsToCsv();
        return account;
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

    public static void saveAccountsToCsv() {

        // Create directory if it does not exist
        try {
            Files.createDirectories(Paths.get("data"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write data to file
        try (PrintWriter csvWriter = new PrintWriter(CSV_PATH)) {

            // Add each account to the CSV File
            for (var entry : accountMap.entrySet()) {
                Integer accountID = entry.getKey();
                Player player = entry.getValue().getPlayer();
                String playerName = player.getName();
                double playerBalance = player.getAccountBalance();
                String csvLine = accountID + "," + playerName + "," + playerBalance;

                csvWriter.println(csvLine);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
