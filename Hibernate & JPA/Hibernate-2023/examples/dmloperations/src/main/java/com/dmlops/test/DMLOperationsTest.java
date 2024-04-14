package com.dmlops.test;

import com.dmlops.entities.ServiceRequest;
import com.dmlops.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class DMLOperationsTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            ServiceRequest serviceRequest = new ServiceRequest();
//            serviceRequest.setRequestType("NEFT Transfer");
//            serviceRequest.setRaisedDate(LocalDate.now());
//            serviceRequest.setCustomerName("Mark");
//            serviceRequest.setEmailAddress("mark@gmail.com");
//            serviceRequest.setMobileNo("8387734");
//            serviceRequest.setProblem("NEFT Transfer fee charges");
//            serviceRequest.setStatus("Open");
//
//            //int serviceRequestNo = (Integer) session.save(serviceRequest);
//            //System.out.println("service request no: " + serviceRequestNo);
//            session.saveOrUpdate(serviceRequest);
//            ServiceRequest serviceRequest= session.get(ServiceRequest.class, 4);
//            serviceRequest.setProblem("Chequebook Request");
//            session.update(serviceRequest);

//            ServiceRequest serviceRequest = new ServiceRequest();
//            serviceRequest.setServiceRequestNo(5);
//            serviceRequest.setRequestType("Account");
//            serviceRequest.setRaisedDate(LocalDate.now());
//            serviceRequest.setCustomerName("Bob");
//            serviceRequest.setEmailAddress("bob@gmail.com");
//            serviceRequest.setMobileNo("9384994");
//            serviceRequest.setProblem("Account Type change");
//            serviceRequest.setStatus("Open");
//            session.update(serviceRequest);
//            System.out.println("service request no (entity object) :" + serviceRequest.getServiceRequestNo());
//            ServiceRequest serviceRequest = session.get(ServiceRequest.class, 4);
//            if(serviceRequest != null) {
//                session.remove(serviceRequest);
//            }
//            ServiceRequest serviceRequest = new ServiceRequest();
//            serviceRequest.setServiceRequestNo(5);
//            session.remove(serviceRequest);

//            ServiceRequest serviceRequest = session.get(ServiceRequest.class, 2);
//            ServiceRequest serviceRequest1 = new ServiceRequest();
//            serviceRequest1.setServiceRequestNo(2);
//            serviceRequest1.setRequestType("Account");
//            serviceRequest1.setProblem("Address Change");
//            serviceRequest1.setEmailAddress(serviceRequest.getEmailAddress());
//            serviceRequest1.setMobileNo(serviceRequest.getMobileNo());
//            serviceRequest1.setRaisedDate(serviceRequest.getRaisedDate());
//            serviceRequest1.setStatus(serviceRequest.getStatus());
//            //session.update(serviceRequest1);
//            session.merge(serviceRequest1);

            ServiceRequest serviceRequest = session.get(ServiceRequest.class, 2);
            serviceRequest.setRequestType("Account");
            session.update(serviceRequest);

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
