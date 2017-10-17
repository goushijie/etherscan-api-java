package com.tenshun.app.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



public class AccountData {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountData that = (AccountData) o;

        return walletId.equals(that.walletId);
    }

    @Override
    public int hashCode() {
        return walletId.hashCode();
    }

    @Override //todo maybe delete later
    public String toString() {
        return "AccountData{" +
                "walletId='" + walletId + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions +
                '}';
    }
}
