package com.example.day08.bank;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("CustomBank");
        Banker banker = new Banker("Chesare", "11-1111");

        banker.approveAccountOpen(bank,"1234-5678-91011", "YoungH");

        try{
            Account account = bank.getAccount("1234-5678-91011");
            account.deposit(10000);
            System.out.println("Deposit successful");
            System.out.println("Balance: " + account.getBalance());

            banker.approveWithdrawal(account, 5000);
            System.out.println("Withdrawal successful");
            System.out.println("Balance: " + account.getBalance());

            banker.approveWithdrawal(account, 10000);   // 예외 케이스
        }catch (accountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
