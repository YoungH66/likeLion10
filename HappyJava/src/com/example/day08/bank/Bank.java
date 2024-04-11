package com.example.day08.bank;

import java.util.ArrayList;
import java.util.List;

// 통장 없음 예외
class accountNotFoundException extends Exception {
    public accountNotFoundException(String msg) {
        super(msg);
    }
}

public class Bank {
    private String BankName;
    // 배열에 쉽게 add 하기 위해 list<> 사용. add로 추가
    private List<Account> BankAccount;

    public Bank(String bankName) {
        BankName = bankName;
        BankAccount = new ArrayList<>();
    }

    public String getBankName() {
        return BankName;
    }

    // 계좌 개설
    public void openAccount(String accountNumber, String accountHolderName) {
        Account account = new Account(accountNumber, accountHolderName);
        BankAccount.add(account);
    }

    // 은행이 가지고 있는 계좌 번호와 주어진 계좌 번호를 매치하여 알맞은 계좌 반환
    public Account getAccount(String accountNumber) throws accountNotFoundException {
        for (Account account : BankAccount) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        // 매치되는 계좌번호가 없으면 예외 처리
        throw new accountNotFoundException("\t\t>>!!No such account");
    }
}
