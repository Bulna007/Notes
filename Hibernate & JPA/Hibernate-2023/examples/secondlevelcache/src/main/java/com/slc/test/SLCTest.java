package com.slc.test;

import com.slc.entities.Product;
import com.slc.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class SLCTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

//            Product p = entityManager.find(Product.class, 1);
//            System.out.println(p.getReviews());
//            entityManager.close();
//            entityManager = entityManagerFactory.createEntityManager();
//            Product p1 = entityManager.find(Product.class, 1);
//            System.out.println(p1.getReviews());

            //TypedQuery<Product> productTypedQuery = entityManager.createQuery("from Product p where p.category=:category", Product.class);
            TypedQuery<Product> productTypedQuery = entityManager.createNamedQuery("fetchProductsByCategory", Product.class)
                    .setHint("org.hibernate.cacheable", "true");
            productTypedQuery.setParameter("category", "electronics");

            // #1
            //from Product p where p.category=:category = returned Products [1,2,4]
            // when we fetch each product, it cached in 2nd level cache

            // #2
            //from Product p where p.category=:category = sql query -> returned Products [1,2,4]
            // fetch products from Cache

            // pagination
            //productTypedQuery.setFirstResult(3);
            //productTypedQuery.setMaxResults(3);

            List<Product> products = productTypedQuery.getResultList();
            products.forEach(p -> System.out.println(p.getProductName()));

            entityManager.close();
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<Product> productTypedQuery1 = entityManager.createQuery("from Product p where p.category=:category", Product.class)
                    .setHint("org.hibernate.cacheable", "true");
            productTypedQuery1.setParameter("category", "electronics");
            List<Product> products1 = productTypedQuery1.getResultList();
            products1.forEach(p -> System.out.println(p.getProductName()));

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}
