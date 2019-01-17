package com.rev.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Disease;
import com.rev.dao.DiseaseDao;
import com.rev.util.HibernateUtil;

/** 
 * @author Max
 *
 *         These are the extrapolations on the Doas in the above package. Blocks
 *         comments above each implementation provide details.
 */

public class DiseaseDaoImpl implements DiseaseDao {

	public SessionFactory sf = HibernateUtil.getSessionFactory();

	/**
	 * This DAOImpl will return a particular disease by the ID #. Within a try
	 * block (unsure if this is necessary) it grabs the current session. Begins a
	 * Transaction. Gets a disease object. Commits the transaction. Closes the
	 * session and returns the disease object.
	 */
	
	@Override
	public Disease getDiseasebyID(int id) {
		Disease d = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			d = (Disease) s.get(Disease.class, id);
			tx.commit();
			s.close();
		}
		return d;
	}

	/**
	 * This DAOImpl will return all diseases. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Creates an
	 * ArrayList of all the diseases objects. Commits the transaction. Closes the
	 * session. Returns the list of all the diseases.
	 */
	
	@Override
	public List<Disease> getAllDiseases() {
		List<Disease> diseases = new ArrayList<>();
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			diseases = s.createQuery("from Disease").getResultList();
			tx.commit();
			s.close();
		}
		return diseases;
	}

	/**
	 * This DAOImpl will update disease information. Within a try block (unsure if
	 * this is necessary) it grabs the current session. Begins a Transaction. Updates
	 * the disease object based on input parameters. Commits the transaction. Closes
	 * the session.
	 */
	
	@Override
	public void updateDisease(Disease disease) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			//using s.update(object) until we need to do s.merge(object)
			s.update(disease);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will add a disease. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Creates a new
	 * disease object. Commits the transaction. Closes the session.
	 */
	
	@Override
	public void addDisease(Disease disease) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(disease);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will delete a disease. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Removes the
	 * disease from persistent to transient. Commits the transaction. Closes the
	 * session.
	 */
	
	@Override
	public void deleteDisease(Disease disease) {
		try(Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.delete(disease);
			tx.commit();
			s.close();
		}
	}

}
