package com.gl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gl.entities.IPassenger;
import com.gl.entities.Passenger;
import com.gl.helper.SFRegistry;

public class GLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();

			// getEagerAndLoadLazy(session, 10);
			// getEagerAndLoadNoRecord(session, 11);
			//getEagerAndLoadDisableLazyLoading(session, 10);
			//getEagerAndLoadDisableLazyThroughInterface(session, 10);
			getEagerAndLoadActiveSession(session, 10);

		} finally {
			if (session != null) {
				session.close();
			}
			SFRegistry.closeSessionFactory();
		}
	}

	private static void getEagerAndLoadLazy(Session session, int passengerNo) {
		Passenger passenger1 = null;
		Passenger passenger2 = null;

		// passenger1 = session.get(Passenger.class, passengerNo);
		passenger2 = session.load(Passenger.class, passengerNo);

		// System.out.println("passenger1 ClassType : " +
		// passenger1.getClass().getName());
		System.out.println("passenger2 ClassType : " + passenger2.getClass().getName());
		System.out.println(passenger2.getPassengerName());
	}

	private static void getEagerAndLoadNoRecord(Session session, int passengerNo) {
		Passenger passenger1 = null;
		Passenger passenger2 = null;

		passenger1 = session.get(Passenger.class, passengerNo);
		if (passenger1 == null) {
			System.out.println("Object not found");
		} else {
			System.out.println("passengerName : " + passenger1.getPassengerName());
		}

		// load fails in if condition, because always it returns proxy
		passenger2 = session.load(Passenger.class, passengerNo);
		if (passenger2 == null) {
			System.out.println("Object not found");
		} else {
			System.out.println("passengerName : " + passenger2.getPassengerName());
		}
	}

	private static void getEagerAndLoadDisableLazyLoading(Session session, int passengerNo) {
		Passenger passenger1 = null;

		// load fails in if condition, because always it returns proxy
		passenger1 = session.load(Passenger.class, passengerNo);
		System.out.println("passenger class: " + passenger1.getClass().getName());

	}
	
	private static void getEagerAndLoadDisableLazyThroughInterface(Session session, int passengerNo) {
		IPassenger passenger1 = null;

		// load fails in if condition, because always it returns proxy
		passenger1 = session.load(IPassenger.class, passengerNo);
		System.out.println("passenger class: " + passenger1.getClass().getName());

	}
	
	private static void getEagerAndLoadActiveSession(Session session, int passengerNo) {
		Passenger passenger1 = null;

		// load fails in if condition, because always it returns proxy
		passenger1 = session.load(Passenger.class, passengerNo);
		session.close();
		System.out.println(passenger1.getPassengerName());

	}
	
	

}
