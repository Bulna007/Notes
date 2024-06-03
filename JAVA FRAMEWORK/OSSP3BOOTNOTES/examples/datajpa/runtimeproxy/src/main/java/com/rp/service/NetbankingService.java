package com.rp.service;

public interface NetbankingService {
    double getBalance(String accountNo);

    String getAccountHolderName(String accountNo);
}
