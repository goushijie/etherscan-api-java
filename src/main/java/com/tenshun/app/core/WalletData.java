package com.tenshun.app.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class WalletData {

    private String walletId;
    private BigDecimal balance;
    private List<String> transactions = new ArrayList<>();

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}
