package com.invs.test;

import com.invs.entities.Product;
import com.invs.entities.Review;
import com.invs.helper.SFRegistry;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvsTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            Review review = Review.of().rating(3).remarks("good for price")
//                    .postedDate(LocalDate.now()).postedBy("marrisa").build();
//
//            Product product = Product.of().productName("260 liters smart refrigerator").category("electronics")
//                    .manufacturer("LG").price(83732).build();
//            Set<Review> reviews = new HashSet<>();
//            reviews.add(review);
//            product.setReviews(reviews);
//
//            review.setProduct(product);
//
//            session.persist(product);
//            session.persist(review);

//            Product product = session.get(Product.class, 1);
//            System.out.println("product name : " + product.getProductName());
//
//            Set<Review> reviews = product.getReviews();
//            reviews.forEach(System.out::println);
            TypedQuery<Product> queryProductsByCategory = session.createQuery("from Product p where p.category=?1", Product.class);
            queryProductsByCategory.setParameter(1, "electronics");
            List<Product> products = queryProductsByCategory.getResultList();

            for(Product product : products) {
                Set<Review> reviews = product.getReviews();
//                for(Review review : reviews) {
//                    System.out.println(review);
//                }
            }

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
