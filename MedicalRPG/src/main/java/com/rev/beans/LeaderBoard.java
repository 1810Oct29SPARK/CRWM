package com.rev.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import javax.persistence.ConstraintMode;

/**
 * Summary * Uses a one to many for fetching the information from player Takes
 * information in the object for the Leaderboard from sql
 * 
 * @author Darius
 */
@Entity
@Table(name = "LEADERBOARD")
public class LeaderBoard {

	public LeaderBoard(int leaderBoard_ID, int players) {
		super();
		this.leaderBoard_ID = leaderBoard_ID;
		this.players = players;
	}

	public LeaderBoard() {
	}

	@Id
	@Column(name = "LEADERBOARD_ID")
	private int leaderBoard_ID;
	@Column(name = "PLAYER_ID")
	private int players;

	public int getLeaderBoard_ID() {
		return leaderBoard_ID;
	}

	public void setLeaderBoard_ID(int leaderBoard_ID) {
		this.leaderBoard_ID = leaderBoard_ID;
	}

	@Override
	public String toString() {
		return "LeaderBoard [LeaderBoard_ID=" + leaderBoard_ID + ", User_ID=" + players + "]";
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaderBoard_ID;
		result = prime * result + players;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LeaderBoard other = (LeaderBoard) obj;
		if (leaderBoard_ID != other.leaderBoard_ID)
			return false;
		if (players != other.players)
			return false;
		return true;
	}
	
}