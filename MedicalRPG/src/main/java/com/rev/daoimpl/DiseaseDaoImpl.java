package com.rev.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Disease;
import com.rev.dao.DiseaseDao;
import com.rev.util.HibernateUtil;

public class DiseaseDaoImpl implements DiseaseDao {

	public SessionFactory sf = HibernateUtil.getSessionFactory();

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

	@Override
	public void addDisease(Disease disease) {
		try (Session s = sf.getCurrentSession()){
			Transaction tx = s.beginTransaction();
			s.persist(disease);
			tx.commit();
			s.close();
		}
	}

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
