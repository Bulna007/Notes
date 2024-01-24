package com.mba.test;

import org.springframework.aop.framework.ProxyFactory;

import com.mba.beans.AuditAdvice;
import com.mba.beans.LoanManager;
import com.mba.beans.SecurityAdvice;
import com.mba.helper.SecurityManager;

public class MBATest {
	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new LoanManager());
		pf.addAdvice(new AuditAdvice());
		pf.addAdvice(new SecurityAdvice());

		LoanManager proxy = (LoanManager) pf.getProxy();
		SecurityManager securityManager = SecurityManager.getInstance();

		securityManager.login("bob", "welcome1");

		boolean approvedLoan = proxy.approveLoan(9383);
		System.out.println("approvedLoan ? : " + approvedLoan);
		securityManager.logout();
	}
}
