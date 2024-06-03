package com.mba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mba.beans.LoanManager;
import com.mba.config.MBAConfig;
import com.mba.helper.SecurityManager;

public class MBATest {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MBAConfig.class);
		LoanManager loanManager = context.getBean("loanManager", LoanManager.class);
		SecurityManager securityManager = context.getBean("securityManager", SecurityManager.class);
		securityManager.login("john", "welcome1");
		boolean approved = loanManager.approveLoan(938);
		System.out.println("approved : " + approved);
		securityManager.logout();
	}
}
