package com.mba.beans;

import org.springframework.stereotype.Component;

@Component
public class LoanManager {
	public boolean approveLoan(long loanApplicationNo) {
		System.out.println("in approveLoan(" + loanApplicationNo + ")");
		return true;
	}
}
