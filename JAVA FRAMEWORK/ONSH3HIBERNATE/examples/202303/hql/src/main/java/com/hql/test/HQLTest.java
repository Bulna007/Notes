package com.hql.test;

import com.hql.entities.Product;
import com.hql.entities.Review;
import com.hql.helper.EMFRegistry;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Map;

public class HQLTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            //showAllProducts(entityManager);
            //showProductsByCategory(entityManager, "footwear");
            //countOfProductsByManufacturer(entityManager, "LG");
            //showCountOfProductsBasedOnCategory(entityManager);
            //showReviewsByProductCategory(entityManager, "footwear");
            //showProductsReviewsByUser(entityManager, "joe");
            showProductsHigherThanAvgPriceInCategory(entityManager, "electronics");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showAllProducts(EntityManager entityManager) {
        TypedQuery<Product> getAllProductsQuery = null;
        List<Product> products = null;

        getAllProductsQuery = entityManager.createQuery("from Product", Product.class);
        products = getAllProductsQuery.getResultList();
        products.forEach(System.out::println);
    }

    private static void showProductsByCategory(EntityManager entityManager, String category) {
        TypedQuery<Product> getProductsByCategoryQuery = null;
        List<Product> products = null;

        getProductsByCategoryQuery = entityManager.createQuery("from Product p where p.category = :category", Product.class);
        getProductsByCategoryQuery.setParameter("category", category);
        products = getProductsByCategoryQuery.getResultList();
        products.forEach(System.out::println);
    }

    private static void countOfProductsByManufacturer(EntityManager entityManager, String manufacturer) {
        TypedQuery<Long> countOfProductsQuery = null;
        long cproducts = 0;

        countOfProductsQuery = entityManager.createQuery("select count(p) from Product p where p.manufacturer = :manufacturer", Long.class);
        countOfProductsQuery.setParameter("manufacturer", manufacturer);
        cproducts = countOfProductsQuery.getSingleResult();

        System.out.println("no of products : " + cproducts);
    }

    private static void showCountOfProductsBasedOnCategory(EntityManager entityManager) {
        TypedQuery<Object[]> countOfProductsBasedonCategoryQuery = null;

        countOfProductsBasedonCategoryQuery = entityManager.createQuery("select p.category, count(p) from Product p group by(p.category)", Object[].class);
        List<Object[]> records = countOfProductsBasedonCategoryQuery.getResultList();
        for (Object[] record : records) {
            System.out.println("category : " + record[0] + " count : " + record[1]);
        }
    }

    private static void showReviewsByProductCategory(EntityManager entityManager, String category) {
        TypedQuery<Review> reviewTypedQuery = null;
        List<Review> reviews = null;

        reviewTypedQuery = entityManager.createQuery("select r from Review r where r.product.category = :category", Review.class);
        reviewTypedQuery.setParameter("category", category);
        reviews = reviewTypedQuery.getResultList();

        for (Review review : reviews) {
            System.out.println(review);
        }
    }

    private static void showProductsReviewsByUser(EntityManager entityManager, String postedBy) {
        TypedQuery<Product> productTypedQuery = null;
        List<Product> products = null;

        productTypedQuery = entityManager.createQuery("select p from Product p inner join p.reviews as r where r.postedBy = :postedBy", Product.class);
        productTypedQuery.setParameter("postedBy", postedBy);
        products = productTypedQuery.getResultList();
        products.forEach(System.out::println);
    }

    private static void showProductsHigherThanAvgPriceInCategory(EntityManager entityManager, String category) {
        TypedQuery<Product> productTypedQuery = null;
        List<Product> products = null;

        productTypedQuery = entityManager.createQuery("select prod from Product prod where prod.category=:category and prod.price > " +
                "(select avg(p.price) from Product p where p.category = :category)", Product.class);
        productTypedQuery.setParameter("category", category);
        products = productTypedQuery.getResultList();
        products.forEach(System.out::println);
    }

}



















