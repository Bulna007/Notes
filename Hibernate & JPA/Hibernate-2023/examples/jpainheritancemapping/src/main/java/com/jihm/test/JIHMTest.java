package com.jihm.test;

import com.jihm.entities.CardPayment;
import com.jihm.entities.ChequePayment;
import com.jihm.entities.Payment;
import com.jihm.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.security.SecureRandom;
import java.time.LocalDate;

public class JIHMTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;
        boolean flag = false;

        try {
            emf = EMFRegistry.getEmf();
            em = emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            //savePayment(em);
            //saveCardPayment(em);
            //saveChequePayment(em);

            //CardPayment cardPayment = em.find(CardPayment.class, 2);
            //System.out.println(cardPayment);

            //Payment payment = em.find(Payment.class, 2);
            //System.out.println(payment);

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
            EMFRegistry.closeEmf();
        }
    }

    private static void savePayment(EntityManager em) throws InstantiationException, IllegalAccessException {
        Payment payment = createPayment(Payment.class, "B9383", "Anthony", "9837849444");
        em.persist(payment);
        System.out.println("payment no : " + payment.getPaymentNo());
    }

    private static void saveCardPayment(EntityManager em) throws InstantiationException, IllegalAccessException {
        CardPayment cardPayment = (CardPayment) createPayment(CardPayment.class, "B0384", "Mathew", "8484794444");
        cardPayment.setCardType("Visa");
        cardPayment.setCardHolderName("Mathew G");
        cardPayment.setBankName("HDFC Bank");
        cardPayment.setPaymentDate(LocalDate.now());
        cardPayment.setValidThru("09/2024");
        cardPayment.setLast4Digits("9993");

        em.persist(cardPayment);
        System.out.println("card payment no : " + cardPayment.getPaymentNo());
    }

    private static void saveChequePayment(EntityManager em) throws InstantiationException, IllegalAccessException {
        ChequePayment chequePayment = (ChequePayment) createPayment(ChequePayment.class, "B0382", "Brad", "938749445");
        chequePayment.setChequeNo("C93284");
        chequePayment.setBankName("ICICI Bank");
        chequePayment.setIssuerName("Brad");
        chequePayment.setChequeDate(LocalDate.now());
        em.persist(chequePayment);
        System.out.println("cheque payment no : " + chequePayment.getPaymentNo());
    }

    private static Payment createPayment(Class<?> classType, String billNo, String customerName, String mobileNo) throws InstantiationException, IllegalAccessException {
        Payment payment = (Payment) classType.newInstance();
        payment.setPaymentDate(LocalDate.now());
        payment.setAmount(new SecureRandom().nextDouble(1000, 60000));
        payment.setBillNo(billNo);
        payment.setCustomerName(customerName);
        payment.setMobileNo(mobileNo);
        return payment;
    }
}










