package com.example.day08.bank;

import java.util.ArrayList;
import java.util.List;


// 잔액부족 예외
class insufficientBalanceException extends Exception {
    public insufficientBalanceException(String message) {
        super(message);
    }
}

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) throws insufficientBalanceException {
        if(amount > balance) {
            throw new insufficientBalanceException("Lack of balance");
        }
        balance = balance - amount;
    }
}
