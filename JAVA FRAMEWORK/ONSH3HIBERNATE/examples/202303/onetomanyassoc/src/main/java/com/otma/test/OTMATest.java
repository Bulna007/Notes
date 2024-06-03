package com.otma.test;

import com.otma.entities.Coach;
import com.otma.entities.Player;
import com.otma.helper.SFRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Iterator;
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

            /*coach = new Coach();
            coach.setCoachName("Rahul Dravid");
            coach.setAge(38);
            coach.setGender("Male");
            coach.setExperience(20);
            coach.setMobileNo("93874948");
            coach.setEmailAddress("rahul@gmail.com");

            player1 = new Player("Virat Kohli", 27, "Male", "983738474", "virat@gmail.com", 5, 80, "Cricket");
            player1.setCoach(coach);
            session.save(player1);*/

//            coach = session.get(Coach.class, 1);
//            player1 = new Player("Rohit", 26, "Male", "8373744222", "rohit@gmail.com", 5, 85, "Cricket");
//            coach.getPlayers().add(player1);
//            session.update(coach);

//            coach = session.get(Coach.class, 1);
//            session.delete(coach);
            coach = session.get(Coach.class, 1);
            Set<Player> playerSet = coach.getPlayers();

            Iterator<Player> playerIterator = playerSet.iterator();
            while(playerIterator.hasNext()) {
                Player player = playerIterator.next();
                if(player.getWeight()> 80) {
                    playerIterator.remove();
                }
            }
            session.update(coach);


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
