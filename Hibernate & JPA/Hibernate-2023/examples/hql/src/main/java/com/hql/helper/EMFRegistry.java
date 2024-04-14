package com.hql.helper;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFRegistry {
    private static EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("hqlpu");
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

}
