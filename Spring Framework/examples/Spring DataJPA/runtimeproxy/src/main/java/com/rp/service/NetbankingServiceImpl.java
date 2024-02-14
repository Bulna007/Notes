package com.rp.service;

public class NetbankingServiceImpl implements NetbankingService {
    @Override
    public double getBalance(String accountNo) {
        System.out.println("getBalance()");
        return 1000;
    }

    @Override
    public String getAccountHolderName(String accountNo) {
        return accountNo + " - Joseph";
    }
}
