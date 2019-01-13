package com.rev.main;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Player;
import com.rev.dao.DiseaseDao;
import com.rev.dao.LeaderBoardDao;
import com.rev.dao.PatientsDao;
import com.rev.dao.PlayerDao;
import com.rev.dao.SymptomDao;
import com.rev.daoimpl.DiseaseDaoImpl;
import com.rev.daoimpl.LeaderBoardDaoImpl;
import com.rev.daoimpl.PatientsDaoImpl;
import com.rev.daoimpl.PlayerDaoImpl;
import com.rev.daoimpl.SymptomDaoImpl;
import com.rev.util.HibernateUtil;

public class Driver {

	static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
//		Single.instance().Dummy();
		PlayerDao pd = new PlayerDaoImpl();
		DiseaseDao dd = new DiseaseDaoImpl();
		LeaderBoardDao lbd = new LeaderBoardDaoImpl();
		PatientsDao ptsd = new PatientsDaoImpl();
		SymptomDao sd = new SymptomDaoImpl();
		System.out.println(pd.getallPlayers());
//		System.out.println(pd.getPlayerByID(10200));
//		Hibernate.initialize(dd.getAllDiseases().get(1));
//		System.out.println(lbd.getAllLeaderBoards());
//		funWithSessions(sf);
	}

	static void funWithSessions(SessionFactory sf) {
		Session s = sf.getCurrentSession();
		Transaction tx = s.beginTransaction();
		Player p1 = s.get(Player.class, 33);
		System.out.println(p1);
		Player p2 = s.get(Player.class, 34);
		System.out.println(p2);
		Player p3 = s.load(Player.class, 10360);
		System.out.println(p3);
		System.out.println(s.save(p3)); // adds a new one
		Player p4 = s.get(Player.class, 10360);
//		p4.setEmail("Boom.com");
		tx.commit();
		s.close();
	}

}
