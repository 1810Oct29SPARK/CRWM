package com.rev.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Symptom;
import com.rev.dao.SymptomDao;
import com.rev.util.HibernateUtil;

/**
 * 
 * @author Max
 *
 */

public class SymptomDaoImpl implements SymptomDao {
	
	// Session factory to obtain session
	SessionFactory sf = HibernateUtil.getSessionFactory();

	/**
	 * This DAOImpl will return a particular symptom by its ID #
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Gets a symptom object
	 * Commits the transaction
	 * Closes the session
	 * returns the symptom object
	 */
	@Override
	public Symptom getSymptomByID(int id) {
		Symptom sp = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			sp = (Symptom) s.get(Symptom.class, id);
			tx.commit();
			s.close();
		}
		return sp;
	}

	/**
	 * This DAOImpl will return all symptoms
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Creates an ArrayList of all the symptom objects
	 * Commits the transaction
	 * Closes the session
	 * Returns the list of all the symptoms
	 */
	@Override
	public List<Symptom> getAllSymptoms() {
		List<Symptom> ls = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			ls = s.createQuery("from Symptom").getResultList();
			tx.commit();
			s.close();
		}
		return ls;
	}

	/**
	 * This DAOImpl will update a symptom information
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Updates the symptom object based on input parameters
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void updateSymptom(Symptom symptom) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using s.update(object) until we need to do s.merge(object
			s.update(symptom);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will create a symptom
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Creates a new symptom object
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void addSymptom(Symptom symptom) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using the .persist() method instead of .save() for now until we start getting exceptions thrown
			s.persist(symptom);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will delete a symptom
	 * Within a try block (unsure if this is necessary) it grabs the current session
	 * Begins a Transaction
	 * Removes the symptom from persistent to transient
	 * Commits the transaction
	 * Closes the session
	 */
	@Override
	public void deleteSymptom(Symptom symptom) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			//using .delete() will remove the object from the DB, but I'm currently unsure if it
			//completely removes the object entirely
			s.delete(symptom);
			tx.commit();
			s.close();
		}
	}

}
