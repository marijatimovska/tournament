package com.iwec.tournament.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.iwec.tournament.model.Event;
import com.iwec.tournament.model.Player;
import com.iwec.tournament.model.Result;

public class App {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		System.out.println("Starting Transaction");
		entityManager.getTransaction().begin();

		Event event = new Event("Bitola", 1000);
		Event eventtwo = new Event("Ohrid", 760);

		System.out.println("Saving Events to Database");

		entityManager.persist(event);
		entityManager.persist(eventtwo);

		Player player = new Player("Petar", "Popovski");
		Player playertwo = new Player("Marija", "Timovska");

		System.out.println("Saving Players to Database");

		entityManager.persist(player);
		entityManager.persist(playertwo);

		Result result = new Result(player, event, 540, 54);
		Result resulttwo = new Result(player, eventtwo, 670, 67);
		Result resultthree = new Result(playertwo, event, 650, 65);
		Result resultfour = new Result(playertwo, eventtwo, 550, 55);

		System.out.println("Saving Results to Database");

		entityManager.persist(result);
		entityManager.persist(resulttwo);
		entityManager.persist(resultthree);
		entityManager.persist(resultfour);

		entityManager.getTransaction().commit();

		/*
		 * @SuppressWarnings("unchecked")
		 * 
		 * List<Result> results = entityManager .createQuery(
		 * "SELECT p.firstName, p.lastName, r.points from Player as p, Result as r where id = player_id"
		 * ) .getResultList();
		 */

		String hql = "SELECT p.firstName, p.lastName, r.points from Player as p, Result as r where id = player_id";
		Query query = entityManager.createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Object[]> itr = query.getResultList();

		for (Object[] row : itr) {
			System.out.println(String.format("First Name:%s, LastName:%s, points:%d", row[0], row[1], row[2]));
		}

		/*
		 * if (results == null)
		 * 
		 * { System.out.println("No results found."); } else { for (Result it : results)
		 * { System.out.println(it); } }
		 */

		entityManager.close();
		entityManagerFactory.close();
	}

}
