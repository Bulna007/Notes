package com.bs3.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs3.entities.Trip;
import com.bs3.helper.ProgSFRegistry;
import com.bs3.helper.PropsSFRegistry;
import com.bs3.helper.XMLSFRegistry;

public class BS3Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Trip trip = null;

		try {
			sessionFactory = ProgSFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			trip = session.get(Trip.class, 1);
			System.out.println(trip);
		} finally {
			if (session != null) {
				session.close();
			}
			ProgSFRegistry.closeSessionFactory();
		}

	}
}
