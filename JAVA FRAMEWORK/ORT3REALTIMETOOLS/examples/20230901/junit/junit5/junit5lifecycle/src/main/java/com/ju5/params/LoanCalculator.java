package com.ju5.params;

import com.ju5.bean.Loan;

public class LoanCalculator {
    public double interestAmount(Loan loan) {
        return (loan.getPrinciple() * loan.getRi() * loan.getTenure()) / 100;
    }
}
