package com.bs3.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropsSFRegistry {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addResource("com/bs3/entities/Trip.hbm.xml");

		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
			sessionFactory = null;
		}
	}
}
