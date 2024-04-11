package com.example.day08;

public class BankAccount {
    private final int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double initialbalance) {
        this.accountNumber = accountNumber;
        this.balance = initialbalance;
    }

    public final String getAccountInfo(){
        return "Account Number: " + accountNumber + " Balance: " + balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        balance -= amount;
    }
}
