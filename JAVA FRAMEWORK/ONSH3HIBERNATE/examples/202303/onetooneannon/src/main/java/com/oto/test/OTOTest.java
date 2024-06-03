package com.oto.test;

import com.oto.entities.Bill;
import com.oto.entities.ItemizedBill;
import com.oto.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class OTOTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            Bill bill = new Bill();
            bill.setBillGeneratedDate(LocalDate.now());
            bill.setCustomerName("Joseph");
            bill.setDueDate(LocalDate.now().plusDays(12));
            bill.setMobileNo("9393797494");
            bill.setBillAmount(299);

            session.persist(bill);
            System.out.println("bill no : " + bill.getBillNo());

            ItemizedBill itemizedBill = new ItemizedBill();
            itemizedBill.setInternationalMessages(10);
            itemizedBill.setLocalMessages(10);
            itemizedBill.setLocalVoiceMinutes(100);
            itemizedBill.setInternationalVoiceMinutes(0);
            itemizedBill.setPreviousDueAmount(0);
            itemizedBill.setBill(bill);

            session.persist(itemizedBill);
            System.out.println("itemized bill no : " + itemizedBill.getBillNo());
//            ItemizedBill itemizedBill = session.get(ItemizedBill.class, 1);
//            System.out.println(itemizedBill.getBill());

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
