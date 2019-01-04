package com.rev.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.Beans.Player;
import com.rev.Dao.PlayerDao;
import com.rev.Hibernate.HibernateTest;
import com.rev.Singleton.Single;

public class PlayerDaoImpl implements PlayerDao {

	//Session factory to obtain session
	SessionFactory sf = HibernateTest.getSession();
	@Override
	public Player getPlayerbyID(int id) {
		Player u = null;
		try(Session s = sf.getCurrentSession())
		{
			System.out.println(Single.instance().toString());
			System.out.println(s.toString());
			Transaction tx =s.beginTransaction();
			u = (Player) s.get(Player.class, id);
			System.out.println(u);
			tx.commit();
		}
		return u;
	}

	@Override
	public List<Player> getallPlayers() {
		List<Player> Players = new ArrayList<>();
		try(Session s = sf.getCurrentSession())
		{
			System.out.println(Single.instance().toString());
			System.out.println(s.toString());
			Transaction tx =s.beginTransaction();
			Players = s.createQuery("from Player").getResultList();
			System.out.println(Players);
			tx.commit();
		}
		return Players;
	}

	@Override
	public void updatePlayer(Player player) {
		// TODO Auto-generated method stub
		try(Session s = sf.getCurrentSession())
		{
			System.out.println(Single.instance().toString());
			System.out.println(s.toString());
			Transaction tx =s.beginTransaction();
			s.update(player);
			tx.commit();
		}	
	}

	@Override
	public void addPlayer(Player player) {
		try(SessionFactory sf = HibernateTest.getSession())
		{
			Session s = sf.getCurrentSession();
			System.out.println(Single.instance().toString());
			System.out.println(s.toString());
			Transaction tx =s.beginTransaction();
			s.save(player);
			tx.commit();
			s.close();
		}		
	}

	@Override
	public void deletePlayer(Player player) {
		// TODO Auto-generated method stub
		try(Session s = sf.getCurrentSession())
		{
			System.out.println(Single.instance().toString());
			System.out.println(s.toString());
			Transaction tx =s.beginTransaction();
			s.delete(player);
			tx.commit();
		}		
	}
}