package com.otmm.test;

import com.otmm.entities.Project;
import com.otmm.entities.Vendor;
import com.otmm.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class OTMMapTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            Project project = new Project();
//            project.setDescription("Road contract");
//            project.setWorkType("civil");
//            project.setEstimatedDays(2);
//            project.setEstimatedAmount(100000);
//            session.persist(project);
//            System.out.println("project no : "+ project.getProjectNo());
//
//            Project project2 = new Project();
//            project2.setDescription("LED Lighting");
//            project2.setWorkType("civil");
//            project2.setEstimatedDays(25);
//            project2.setEstimatedAmount(2500000);
//            session.persist(project2);
//            System.out.println("project no : "+ project2.getProjectNo());
//
//            Map<String, Project> allottedProjects = new HashMap<>();
//            allottedProjects.put("C001", project2);
//            allottedProjects.put("C00028", project);
//
//            Vendor vendor = new Vendor();
//            vendor.setVendorName("L&T");
//            vendor.setContactNo("93847944");
//            vendor.setEmailAddress("contactus@lt.com");
//            vendor.setEstablishedDate(LocalDate.now());
//            vendor.setAllottedProjects(allottedProjects);
//            session.persist(vendor);
//
//            System.out.println("vendor no : " + vendor.getVendorNo());
            Vendor vendor = session.get(Vendor.class, 1);
            Map<String, Project> allottedProjects = vendor.getAllottedProjects();
            Project project = allottedProjects.get("C001");
            System.out.println(project);



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
