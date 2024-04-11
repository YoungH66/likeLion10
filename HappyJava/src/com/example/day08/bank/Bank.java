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
    private List<Account> BankAccount;

    public Bank(String bankName) {
        BankName = bankName;
        BankAccount = new ArrayList<>();
    }
    public String getBankName() {
        return BankName;
    }

    public void openAccount(String accountNumber, String accountHolderName) {
        Account account = new Account(accountNumber, accountHolderName);
        BankAccount.add(account);
    }

    public Account getAccount(String accountNumber) throws accountNotFoundException {
        for (Account account : BankAccount) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new accountNotFoundException("No such account");
    }
}
