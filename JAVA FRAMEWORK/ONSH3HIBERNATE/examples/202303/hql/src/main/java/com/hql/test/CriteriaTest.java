package com.hql.test;

import com.hql.entities.Product;
import com.hql.entities.Product_;
import com.hql.entities.Review;
import com.hql.entities.Review_;
import com.hql.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            //showAllProducts(entityManager);
            //showProductsNamesByCategory(entityManager, "electronics");
            //showNoOfProductsForEachCategory(entityManager);
            //showAllProductsByManufacturerAndCategory(entityManager, "LG", "electronics");
            //showAllProductsByManufacturer(entityManager, "LG");
            //showProductsReviewedByUser(entityManager, "Joe");
            showReviewsForProductCategory(entityManager, "electronics");
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showAllProducts(EntityManager entityManager) {
        TypedQuery<Product> getAllProductsQuery = null;
        CriteriaQuery<Product> criteriaQuery = null;
        List<Product> products = null;
        Root<Product> root = null;
        CriteriaBuilder cb = null;

        cb = entityManager.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Product.class);
        root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);

        getAllProductsQuery = entityManager.createQuery(criteriaQuery);
        products = getAllProductsQuery.getResultList();
        products.forEach(System.out::println);
    }

    private static void showProductsNamesByCategory(EntityManager entityManager, String category) {
        TypedQuery<String> getProductNamesQuery = null;
        List<String> productNames = null;
        CriteriaQuery<String> cq = null;
        CriteriaBuilder cb = null;
        Root<Product> root = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(String.class);

        root = cq.from(Product.class); //from Clause
        cq.select(root.get("productName")); // select Clause
        cq.where(cb.like(root.get("category"), category));

        getProductNamesQuery = entityManager.createQuery(cq);
        productNames = getProductNamesQuery.getResultList();
        productNames.forEach(System.out::println);
    }

    private static void showNoOfProductsForEachCategory(EntityManager entityManager) {
        CriteriaBuilder cb = null;
        CriteriaQuery<Object[]> cq = null;
        TypedQuery<Object[]> tq = null;
        List<Object[]> data = null;
        Root<Product> root = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(Object[].class);

        root = cq.from(Product.class);
        cq.multiselect(cb.count(root.get("productNo")), root.get("category")).groupBy(root.get("category"));
        tq = entityManager.createQuery(cq);
        data = tq.getResultList();
        data.forEach(record -> {
            System.out.println("category :" + record[1] + " no of products : " + record[0]);
        });
    }

    private static void showAllProductsByManufacturerAndCategory(EntityManager entityManager, String manufacturer, String category) {
        TypedQuery<Product> getAllProductsQuery = null;
        CriteriaQuery<Product> cq = null;
        List<Product> products = null;
        Root<Product> root = null;
        CriteriaBuilder cb = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(Product.class);

        root = cq.from(Product.class);
        cq.select(root);
        cq.where(cb.and(cb.like(root.get("manufacturer"), manufacturer),
                cb.like(root.get("category"), category)));
        // from Product where manufacturer like ? and category like ?

        getAllProductsQuery = entityManager.createQuery(cq);
        products = getAllProductsQuery.getResultList();
        products.forEach(System.out::println);
    }

    private static void showAllProductsByManufacturer(EntityManager entityManager, String manufacturer) {
        CriteriaBuilder cb = null;
        Root<Product> root = null;
        CriteriaQuery<Product> cq = null;
        TypedQuery<Product> typedQuery = null;
        List<Product> products = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(Product.class);
        root = cq.from(Product.class);
        cq.select(root);

        cq.where(cb.like(root.get(Product_.MANUFACTURER), manufacturer));
        typedQuery = entityManager.createQuery(cq);

        products = typedQuery.getResultList();
        products.forEach(p -> {
            System.out.println(p);
        });
    }

    private static void showProductsReviewedByUser(EntityManager entityManager, String postedBy) {
        CriteriaBuilder cb = null;
        Root<Product> root = null;
        TypedQuery<Product> tq = null;
        CriteriaQuery<Product> cq = null;
        List<Product> products = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(Product.class);

        root = cq.from(Product.class);
        cq.select(root);
        Join<Product, Review> reviewJoin = root.join(Product_.REVIEWS);
        cq.where(cb.like(reviewJoin.get(Review_.POSTED_BY), postedBy));
        tq = entityManager.createQuery(cq);
        products = tq.getResultList();
        products.forEach(System.out::println);
    }

    private static void showReviewsForProductCategory(EntityManager entityManager, String category) {
        CriteriaBuilder cb = null;
        Root<Review> root = null;
        TypedQuery<Review> tq = null;
        CriteriaQuery<Review> cq = null;
        List<Review> reviews = null;

        cb = entityManager.getCriteriaBuilder();
        cq = cb.createQuery(Review.class);
        root = cq.from(Review.class);
        cq.select(root);
        Join<Review, Product> productJoin = root.join(Review_.PRODUCT);
        cq.where(cb.like(productJoin.get(Product_.CATEGORY), category));
        tq = entityManager.createQuery(cq);
        reviews = tq.getResultList();
        reviews.forEach(System.out::println);
    }
}



















