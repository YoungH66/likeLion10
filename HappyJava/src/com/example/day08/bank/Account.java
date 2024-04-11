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
        // 신규 개설이기때문에 잔액은 0
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        System.out.println("Dispalying account holder...");
        return accountHolder;
    }

    public double getBalance() {
        System.out.println("Dispalying balance...");
        return balance;
    }

    // 입금
    public void deposit(double amount) {
        System.out.println("\t>>Request for deposit");
        balance = balance + amount;
    }

    // 출금
    public void withdraw(double amount) throws insufficientBalanceException {
        System.out.println("\t>>Request for withdraw");
        // 만약 계좌 잔액이 출금액수보다 적으면 예외 발생
        if(amount > balance) {
            throw new insufficientBalanceException("\t\t>>!!Lack of balance");
        }
        balance = balance - amount;

        // try-catch로 해보려 했는데 try내부에서 사용자 정의 예외를 적용하는 방법이 헷갈림.
        // 떠넘기기로 조건이 충족되면 예외발생하도록 함.
    }

    // 계좌 상세정보 출력
    public void showAccountDetails() {
        System.out.println("\t>>Show account details");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}
