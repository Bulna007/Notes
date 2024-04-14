package com.bs3.helper;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProgSFRegistry {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration configuration = new Configuration(); // empty
			Properties props = new Properties();
			props.load(ProgSFRegistry.class.getClassLoader().getResourceAsStream("app.properties"));

			configuration.setProperty("hibernate.connection.driver_class", props.getProperty("db.driverClassname"));
			configuration.setProperty("hibernate.connection.url", props.getProperty("db.url"));
			configuration.setProperty("hibernate.connection.username", props.getProperty("db.username"));
			configuration.setProperty("hibernate.connection.password", props.getProperty("db.password"));
			configuration.setProperty("hibernate.show_sql", props.getProperty("hib.props.show_sql"));
			configuration.setProperty("hibernate.dialect", props.getProperty("hib.props.dialect"));

			configuration.addResource("com/bs3/entities/Trip.hbm.xml");

			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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
