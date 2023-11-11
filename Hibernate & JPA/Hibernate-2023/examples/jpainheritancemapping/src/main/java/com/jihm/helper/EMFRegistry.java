package com.jihm.helper;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMFRegistry {
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("paymentPU");
        } catch (Throwable t) {
            t.printStackTrace();
            throw t;
        }
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void closeEmf() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }
}
