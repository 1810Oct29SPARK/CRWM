package com.rev.main;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.Player;
import com.rev.dao.DiseaseDao;
import com.rev.dao.PatientsDao;
import com.rev.dao.PlayerDao;
import com.rev.daoimpl.DiseaseDaoImpl;
import com.rev.daoimpl.PatientsDaoImpl;
import com.rev.daoimpl.PlayerDaoImpl;
import com.rev.service.DiseaseService;
import com.rev.util.HibernateUtil;

public class Driver {

	static SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
//		Single.instance().Dummy();
		
		//Player
		PlayerDao pd = new PlayerDaoImpl();
//		System.out.println(pd.getallPlayers());
//		System.out.println(pd.getPlayerByID(10200));
//		System.out.println(pd.getPlayersByHighScore());
//		Player p = new Player("doctorstrangelove", "yeet", "John", "Doe");
//		pd.addPlayer(p);
		
		//Patient
		PatientsDao pat = new PatientsDaoImpl();
//		System.out.println(pat.getPatientsByID(1));
//		System.out.println(pat.getAllPatients());

		//Disease
		DiseaseDao dd = new DiseaseDaoImpl();
//		DiseaseService ds = new DiseaseService();
//		Random r = new Random();
//		int n = r.nextInt(6) + 1;
//		System.out.println(ds.getDiseasebyID(n));

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
		tx.commit();
		s.close();
	}

}
