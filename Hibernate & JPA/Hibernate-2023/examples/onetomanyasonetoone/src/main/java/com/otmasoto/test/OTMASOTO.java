package com.otmasoto.test;

import com.otmasoto.entities.Account;
import com.otmasoto.entities.Locker;
import com.otmasoto.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OTMASOTO {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            Account account = new Account();
//            account.setAccountType("Savings");
//            account.setAccountHolderName("Brad");
//            account.setIfscCode("IFSC0019");
//            account.setBalance(3000);
//            session.persist(account);
//
//            System.out.println("account no :" + account.getAccountNo());
//
//            Locker locker = new Locker();
//            locker.setDimensions("10X10X9");
//            locker.setBranchCode("IFSC0019");
//            locker.setKeyNo(87);
//            locker.setTermsAndConditions("30 days of intimation before closing");
//            locker.setCharges(200);
//            locker.setAccount(account);
//
//            session.persist(locker);
//            System.out.println("locker no  : " + locker.getLockerNo());

//            Account account = session.get(Account.class, 1);
//            System.out.println(account);
            Locker locker = session.get(Locker.class, 1);
            System.out.println("key no : " + locker.getKeyNo());
            Account account = locker.getAccount();

            System.out.println(account);

            flag = true;
        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
            }
            if (session != null) {
                session.close();
            }
            SFRegistry.closeSessionFactory();
        }
    }

}
