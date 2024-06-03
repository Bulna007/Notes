package com.msf.test;

import com.msf.dao.LoanEnquireDao;
import com.msf.entities.LoanEnquire;
import com.msf.helper.SessionFactoryRegistry;

public class MSFTest {
	public static void main(String[] args) {
		try {
			LoanEnquireDao dao = new LoanEnquireDao();
			LoanEnquire enquire = dao.findLoanEnquire(1001);
			System.out.println(enquire);
		} finally {
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
