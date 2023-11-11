package com.smt.test;

import com.smt.entities.Branch;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SMTTest {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgtpu");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        boolean flag = false;

        try {
            Branch branch = new Branch();
            branch.setBranchName("Kondapur Branch");
            branch.setBankName("HDFC Bank");
            branch.setCity("Hyderabad");
            branch.setLocation("Kondapur");
            branch.setIfscCode("IFSC00383");
            branch.setStatus("Active");

            em.persist(branch);
            flag = true;
        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
            }
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}
