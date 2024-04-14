package com.otma.test;

import com.otma.entities.Coach;
import com.otma.entities.Player;
import com.otma.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class OTMATest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        Coach coach = null;
        Player player1 = null;
        Player player2 = null;
        Set<Player> players = null;

        try {
            sessionFactory = SFRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

//            player1 = new Player("Virat Kohli", 27, "Male", "983738474", "virat@gmail.com", 5, 80, "Cricket");
//            session.persist(player1);
//            player2 = new Player("Gautam Gambir", 29, "Male", "82638444", "gambhir@gmail.com", 6, 70, "Cricket");
//            session.persist(player2);
//
//            players = new HashSet<>();
//            players.add(player1);
//            players.add(player2);
//
//            coach = new Coach();
//            coach.setCoachName("Rahul Dravid");
//            coach.setAge(38);
//            coach.setGender("Male");
//            coach.setExperience(20);
//            coach.setMobileNo("93874948");
//            coach.setEmailAddress("rahul@gmail.com");
//            coach.setPlayers(players);
//
//            session.persist(coach);

            coach = session.get(Coach.class, 1);
            System.out.println("coach name : " +coach.getCoachName());

            players = coach.getPlayers();
            players.forEach(System.out::println);


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
