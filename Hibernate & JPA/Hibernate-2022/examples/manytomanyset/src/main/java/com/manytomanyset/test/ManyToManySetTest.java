package com.manytomanyset.test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.manytomanyset.entities.Player;
import com.manytomanyset.entities.Team;
import com.manytomanyset.helper.SessionFactoryRegistry;

public class ManyToManySetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

//			Player player1 = Player.builder().playerName("Sachin").rank(1).gender("Male").dob(LocalDate.of(1970, 2, 23))
//					.nationality("Indian").build();
//			Player player2 = Player.builder().playerName("Rahul Dravid").rank(2).gender("Male")
//					.dob(LocalDate.of(1976, 3, 23)).nationality("Indian").build();
//			session.save(player1);
//			session.save(player2);
//			Set<Player> players = Stream.of(new Player[] { player1, player2 }).collect(Collectors.toSet());
//
//			Team team = Team.builder().teamName("India Team").captain("Saurav").coach("Kapil")
//					.description("Indian Team").representationCountry("India").players(players).build();
//
//			session.save(team);
			Team team = session.get(Team.class, 1);
			System.out.println(team);

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
			SessionFactoryRegistry.closeSessionFactory();
		}

	}
}
