package com.mba.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mba.beans.LoanManager;
import com.mba.helper.SecurityManager;

public class MBATest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/mba/common/application-context.xml");
		LoanManager loanManager = context.getBean("loanManager", LoanManager.class);
		SecurityManager securityManager = context.getBean("securityManager", SecurityManager.class);
		securityManager.login("robert", "welcome1");
		boolean approved = loanManager.approveLoan(938L);
		System.out.println("approved ? :" + approved);
		securityManager.logout();
	}
}
