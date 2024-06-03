package com.otmasoto.entities;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable {
    private int accountNo;
    private String accountHolderName;
    private String accountType;
    private String ifscCode;
    private double balance;

    public int getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return getAccountHolderName().equals(account.getAccountHolderName()) && getAccountType().equals(account.getAccountType()) && getIfscCode().equals(account.getIfscCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAccountHolderName(), getAccountType(), getIfscCode());
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNo=" + accountNo +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountType='" + accountType + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", balance=" + balance +
                '}';
    }
}
