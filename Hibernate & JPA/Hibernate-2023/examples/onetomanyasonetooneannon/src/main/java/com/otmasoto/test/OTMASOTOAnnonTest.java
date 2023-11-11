package com.otmasoto.test;

import com.otmasoto.entities.SetTopbox;
import com.otmasoto.entities.Subscription;
import com.otmasoto.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Set;

public class OTMASOTOAnnonTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            SetTopbox setTopbox = SetTopbox.of().boxType("HD").manufacturer("Cisco").price(500).build();
//            session.persist(setTopbox);
//            System.out.println("settop box no : " +setTopbox.getSerialNo());

//            SetTopbox setTopbox = session.get(SetTopbox.class, 1);
//            Subscription subscription = Subscription.of().subscriberName("Andy").plan("Ultimate999").provider("airtel").monthlyCharges(999).setTopbox(setTopbox).build();
//            session.persist(subscription);
//            System.out.println("subscription no : " + subscription.getSubscriptionNo());
            SetTopbox setTopbox = session.get(SetTopbox.class, 1);
            Set<Subscription> subscriptions = setTopbox.getSubscriptions();
            subscriptions.forEach(System.out::println);


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
