package com.example.day08.bank;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank("CustomBank");
        Banker banker = new Banker("Medici", "11-1111");

        System.out.println(" === Bank Open === ");
        // 계좌 개설 요청
        banker.approveAccountOpen(bank,"1234-5678-91011", "YoungH");
        banker.approveAccountOpen(bank, "1234-1234-12345", "Anno");
        System.out.println();

        try{
            // 해당 계좌 번호로 연결
            // 없으면 예외 발생
            // Account errAcc = bank.getAccount("1234-1234-12345");
            Account account = bank.getAccount("1234-5678-91011");
            System.out.println("Display account number...\n" + account.getAccountNumber() + "\n");

            // 해당 계좌 입금 요청
            account.deposit(10000);
            System.out.println("Deposit successful");
            System.out.println("Balance: " + account.getBalance() + "\n");

            // 해당 계좌 출금 요청
            banker.approveWithdrawal(account, 5000);
            System.out.println("Withdrawal successful");
            System.out.println("Balance: " + account.getBalance() + "\n");

            // banker.approveWithdrawal(account, 10000);   // 예외 케이스

            Account account2 = bank.getAccount("1234-1234-12345");
            // 계좌 정보 조회
            account.showAccountDetails();
            System.out.println();
            account2.showAccountDetails();

        }catch (accountNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
