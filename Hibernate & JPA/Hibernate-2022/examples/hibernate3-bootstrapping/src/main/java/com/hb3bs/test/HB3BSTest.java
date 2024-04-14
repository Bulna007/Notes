package com.hb3bs.test;

import com.hb3bs.dao.PolicyDao;
import com.hb3bs.entities.Policy;
import com.hb3bs.helper.PropsSessionFactoryRegistry;

public class HB3BSTest {
	public static void main(String[] args) {
		try {
			PolicyDao policyDao = new PolicyDao();
			Policy policy = policyDao.getPolicy(1);
			System.out.println(policy);
		} finally {
			PropsSessionFactoryRegistry.closeSessionFactory();
		}
	}
}
