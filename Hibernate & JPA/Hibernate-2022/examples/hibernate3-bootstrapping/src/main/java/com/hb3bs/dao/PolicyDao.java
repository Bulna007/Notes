package com.hb3bs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hb3bs.entities.Policy;
import com.hb3bs.helper.PropsSessionFactoryRegistry;

public class PolicyDao {
	public Policy getPolicy(int policyNo) {
		Policy policy = null;
		Session session = null;
		SessionFactory sessionFactory = null;

		try {
			sessionFactory = PropsSessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			policy = session.get(Policy.class, policyNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return policy;
	}
}
