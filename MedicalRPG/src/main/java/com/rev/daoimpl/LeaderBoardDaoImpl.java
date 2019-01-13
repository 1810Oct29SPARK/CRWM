package com.rev.daoimpl;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.rev.beans.LeaderBoard;
import com.rev.dao.LeaderBoardDao;
import com.rev.util.HibernateUtil;

public class LeaderBoardDaoImpl implements LeaderBoardDao {

	// Session factory to obtain session
	public SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public LeaderBoard getLeaderBoardbyID(int id) {
		LeaderBoard lb = null;
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			lb = (LeaderBoard) s.get(LeaderBoard.class, id);
			tx.commit();
			s.close();
		}
		return lb;
	}

	@Override
	public List<LeaderBoard> getAllLeaderBoards() {
		List<LeaderBoard> lbs = new ArrayList<>();
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			lbs = s.createQuery("from LeaderBoard").getResultList();
			tx.commit();
			s.close();
		}
		return lbs;
	}

	@Override
	public void updateLeaderBoard(LeaderBoard leaderBoard) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.update(leaderBoard);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void addLeaderBoard(LeaderBoard leaderBoard) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.persist(leaderBoard);
			tx.commit();
			s.close();
		}
	}

	@Override
	public void deleteLeaderBoard(LeaderBoard leaderBoard) {
		try (Session s = sf.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			s.delete(leaderBoard);
			tx.commit();
			s.close();
		}
	}

}
