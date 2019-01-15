package com.rev.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Summary * Uses a one to many for fetching the information from player Takes
 * information in the object for the Leaderboard from sql
 * 
 * @author Darius
 */
@Entity
@Table(name = "LEADERBOARD")
public class LeaderBoard {

	public LeaderBoard(int leaderBoard_ID, Player players) {
		super();
		this.leaderBoard_ID = leaderBoard_ID;
		this.players = players;
	}

	public LeaderBoard() {
	}

	@Id
	@Column(name = "LEADERBOARD_ID")
	private int leaderBoard_ID;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL, CascadeType.REMOVE })
	@JoinColumn(name = "PLAYER_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private Player players;

	public int getLeaderBoard_ID() {
		return leaderBoard_ID;
	}

	public void setLeaderBoard_ID(int leaderBoard_ID) {
		this.leaderBoard_ID = leaderBoard_ID;
	}

	@Override
	public String toString() {
		return "LeaderBoard [LeaderBoard_ID=" + leaderBoard_ID + ", Player=" + players + "]";
	}

	public Player getPlayers() {
		return players;
	}

	public void setPlayers(Player players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + leaderBoard_ID;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
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
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}

	
	
}