package com.cid.test;

import com.cid.entities.Person;
import com.cid.entities.PersonPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CIDTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        Person person = null;

        try {
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            person = new Person();
//            person.setFirstName("Greg");
//            person.setLastName("Paul");
//            person.setAge(23);
//            person.setGender("Male");
//            person.setEmailAddress("greg.paul@gmail.com");
//            person.setMobileNo("9384894945");
//
//            session.persist(person);
            PersonPK id= new PersonPK();
            id.setFirstName("Greg");
            id.setLastName("Paul");
            person =session.get(Person.class, id);
            System.out.println(person);

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
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }
}
