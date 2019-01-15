package com.rev.dao;

import java.util.List;

import com.rev.beans.LeaderBoard;

public interface LeaderBoardDao {
	public LeaderBoard getLeaderBoardbyID(int id);
	public List<LeaderBoard> getAllLeaderBoards();
	public void updateLeaderBoard(LeaderBoard leaderBoard);
	public void addLeaderBoard(LeaderBoard leaderBoard);
	public void deleteLeaderBoard(LeaderBoard leaderBoard);
}
