package com.jcid.test;

import com.jcid.entities.Account;
import com.jcid.entities.AccountPK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JCIDTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        boolean flag = false;

        try {
            emf = Persistence.createEntityManagerFactory("cidpu");
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

//            AccountPK id = new AccountPK();
//            id.setAccountNumber("AC00000191");
//            id.setIfscCode("IFSC0383");
//
//            Account account = new Account();
//            account.setId(id);
//            account.setAccountHolderName("Fedrick");
//            account.setAccountType("savings");
//            account.setBalance(9383);
//
//            em.persist(account);
            AccountPK id= new AccountPK();
            id.setAccountNumber("AC00000191");
            id.setIfscCode("IFSC0383");

            Account account = em.find(Account.class, id);
            System.out.println(account);

            flag = true;
        } finally {
            if (et != null) {
                if (flag) {
                    et.commit();
                } else {
                    et.rollback();
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
