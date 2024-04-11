package com.example.day08.bank;


public class Banker {
    private String name;
    private String bankId;

    public Banker(String name, String bankId) {
        this.name = name;
        this.bankId = bankId;
    }

    public void approveAccountOpen(Bank bank, String accountNumber, String accountHolderName) {
        bank.openAccount(accountNumber, accountHolderName);
        System.out.println("Your opening has been completed.");
    }

    public void approveWithdrawal(Account account, double amount) {
        try {
            account.withdraw(amount);
            System.out.println("Your withdrawal request has been completed.");
        } catch (insufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
