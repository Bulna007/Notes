package com.oto.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SFRegistry {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure();
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
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
