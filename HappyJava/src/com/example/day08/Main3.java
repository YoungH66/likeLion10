package com.example.day08;

public class Main3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345, 1000.0);
        System.out.println(account.getAccountInfo());

        account.deposit(500);
        System.out.println(account.getAccountInfo());

        account.withdraw(200);
        System.out.println(account.getAccountInfo());
    }
}
