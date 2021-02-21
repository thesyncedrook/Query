package com.query.query.objectmapper;

import java.time.LocalDateTime;

public class GeneralObject {
    private Integer transactonNumber;
    private String accountNumber;
    private LocalDateTime transactionTs;
    private Double amount;
    private String transactionType;
    private String type;
    private double balance;
    private LocalDateTime lastUpdateTimeStamp;

    public Integer getTransactonNumber() {
        return transactonNumber;
    }

    public void setTransactonNumber(Integer transactonNumber) {
        this.transactonNumber = transactonNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getTransactionTs() {
        return transactionTs;
    }

    public void setTransactionTs(LocalDateTime transactionTs) {
        this.transactionTs = transactionTs;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GeneralObject{" +
                "transactonNumber=" + transactonNumber +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionTs=" + transactionTs +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", lastUpdateTimeStamp=" + lastUpdateTimeStamp +
                '}';
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getLastUpdateTimeStamp() {
        return lastUpdateTimeStamp;
    }

    public void setLastUpdateTimeStamp(LocalDateTime lastUpdateTimeStamp) {
        this.lastUpdateTimeStamp = lastUpdateTimeStamp;
    }
}
