package com.rev.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Player;
import com.rev.dao.PlayerDao;
import com.rev.util.HibernateUtil;

/**
 * 
 * @author Max
 *
 */

public class PlayerDaoImpl implements PlayerDao {

	// Session factory to obtain session
	public SessionFactory sf = HibernateUtil.getSessionFactory();

	/**
	 * This DAOImpl will return a particular player by their ID #
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Gets a player object
	 * Commits the transaction
	 * Closes the session
	 * returns the player object
	 */
	@Override
	public Player getPlayerByID(int id) {
		Player u = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			u = (Player) s.get(Player.class, id);
			tx.commit();
			s.close();
		}
		return u;
	}

	/**
	 * This DAOImpl will return all players
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Creates an ArrayList of all the player objects
	 * Commits the transaction
	 * Closes the session
	 * Returns the list of all the players
	 */
	@Override
	public List<Player> getallPlayers() {
		List<Player> players = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			players = s.createQuery("from Player").getResultList();
			tx.commit();
			s.close();
		}
		return players;
	}

	/**
	 * This DAOImpl will update a player information
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Updates the player object based on input parameters
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void updatePlayer(Player player) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using s.update(object) until we need to do s.merge(object)
			s.update(player);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will add a player
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Creates a new player object
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void addPlayer(Player player) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using the .persist() method instead of .save() for now until we start getting exceptions thrown
			s.persist(player);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will delete a player
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Removes the player from persistent to transient
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void deletePlayer(Player player) {
		//
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using .delete() will remove the object from the DB, but I'm currently unsure if it
			//completely removes the object entirely
			s.delete(player);
			tx.commit();
			s.close();
		}
	}
}