package com.flc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flc.entities.Product;
import com.flc.helper.SFRegistry;

public class FLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SFRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			Product product1 = session.get(Product.class, 1);
//			session.close();
//			session = sessionFactory.openSession();
//			Product product2 = session.get(Product.class, 1);

			// System.out.println("product1 == product2 ? : " + (product1 == product2));
//			Product product = new Product();
//			product.setProductNo(3);
//			product.setProductName("Refrigerator");
//			product.setDescription("Fridge 160 Liters");
//			product.setManufacturerName("Samsung");
//			product.setCategory("electronics");
//			product.setPrice(40900);

			//session.persist(product);
			
//			Product product = session.get(Product.class, 3);
//			product.setProductName("Samsung Fridge 180 Liters");
//			session.update(product);
//			
//			product.setPrice(45000);
//			session.update(product);
			
			Product product1 = session.get(Product.class, 1);
			//session.evict(product1);
			session.clear();
			
			Product product2 = session.get(Product.class, 1);
			
			
			
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









