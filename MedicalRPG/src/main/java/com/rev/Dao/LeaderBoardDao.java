package com.rev.Dao;

import java.util.List;

import com.rev.Beans.LeaderBoard;

public interface LeaderBoardDao {
	//simple CRUD methods
	public LeaderBoard getLeaderBoardbyID(int id);

	public List<LeaderBoard> getAllLeaderBoards();

	public void updateLeaderBoard(LeaderBoard leaderBoard);

	public void addLeaderBoard(LeaderBoard leaderBoard);

	public void deleteLeaderBoard(LeaderBoard leaderBoard);
}