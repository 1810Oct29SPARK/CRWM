package com.rev.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Patients;
import com.rev.dao.PatientsDao;
import com.rev.util.HibernateUtil;

/** 
 * @author Max
 *
 *         These are the extrapolations on the Doas in the above package. Blocks
 *         comments above each implementation provide details.
 */

public class PatientsDaoImpl implements PatientsDao {

	// Session factory to obtain session
	SessionFactory sf = HibernateUtil.getSessionFactory();

	/**
	 * This DAOImpl will return a particular patient by the ID #. Within a try
	 * block (unsure if this is necessary) it grabs the current session. Begins a
	 * Transaction. Gets a patient object. Commits the transaction. Closes the
	 * session and returns the patient object.
	 */
	
	@Override
	public Patients getPatientsByID(int id) {
		Patients p = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			p = (Patients) s.get(Patients.class, id);
			tx.commit();
			s.close();
		}
		return p;
	}

	/**
	 * This DAOImpl will return all patients. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Creates an
	 * ArrayList of all the patients objects. Commits the transaction. Closes the
	 * session. Returns the list of all the patients.
	 */
	
	@Override
	public List<Patients> getAllPatients() {
		List<Patients> lp = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			lp = s.createQuery("from Patients").getResultList();
			tx.commit();
			s.close();
		}
		return lp;
	}

	/**
	 * This DAOImpl will update patient information. Within a try block (unsure if
	 * this is necessary) it grabs the current session. Begins a Transaction. Updates
	 * the patient object based on input parameters. Commits the transaction. Closes
	 * the session.
	 */
	
	@Override
	public void updatePatients(Patients patients) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(patients);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will add a patient. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Creates a new
	 * patient object. Commits the transaction. Closes the session.
	 */
	
	@Override
	public void addPatients(Patients patients) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(patients);
			tx.commit();
			s.close();
		}
	}

	/**
	 * This DAOImpl will delete a patient. Within a try block (unsure if this is
	 * necessary) it grabs the current session. Begins a Transaction. Removes the
	 * patient from persistent to transient. Commits the transaction. Closes the
	 * session.
	 */
	
	@Override
	public void deletePatients(Patients patients) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(patients);
			tx.commit();
			s.close();
		}
	}


}
