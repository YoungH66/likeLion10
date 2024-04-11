package com.example.day08.bank;


public class Banker {
    private String name;
    private String bankId;

    public Banker(String name, String bankId) {
        this.name = name;
        this.bankId = bankId;
    }

    // 계좌 개설 승인
    public void approveAccountOpen(Bank bank, String accountNumber, String accountHolderName) {
        System.out.println("Request to open an account...");
        bank.openAccount(accountNumber, accountHolderName);
        System.out.println("\t>>Your request to open an account has been accepted.");
    }

    // 출금 승인
    // 예외 발생 가능
    public void approveWithdrawal(Account account, double amount) {
        try {
            account.withdraw(amount);
            System.out.println("\t>>Your withdrawal request has been completed.");
        } catch (insufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}
