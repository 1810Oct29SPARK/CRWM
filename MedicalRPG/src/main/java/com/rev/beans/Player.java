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
 * Summary *
 * Player information from login goes into here
 * @author Darius
 */

@Entity
@Table(name="PLAYER")
public class Player {
	public Player()
	{
		
	}

public Player(int player_ID, String username, String password, int score, String firstname, String lastname,
		String isdev, LeaderBoard leader) {
		super();
		this.player_ID = player_ID;
		this.username = username;
		this.password = password;
		this.score = score;
		this.firstname = firstname;
		this.lastname = lastname;
		this.isdev = isdev;
		this.leader = leader;
	}
	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO, generator="playerSequence")
	@SequenceGenerator(allocationSize= 1,name="playerSequence",sequenceName="SQ_PLAYER_PK")*/
	@Column(name="PLAYER_ID")
	private int player_ID;
	@Column(name="USERNAME")
	private String username;
	@Column(name="PLAYER_PASSWORD")
	private String password;
	@Column(name="HIGH_SCORES")
	private int score;
	@Column(name="FIRST_NAME")
	private String firstname;
	@Column(name="LAST_NAME")
	private String lastname;
	@Column(name="IS_DEV")
	private String isdev;
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL, CascadeType.REMOVE })
	@JoinColumn(name="LEADERBOARD_ID", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
	private LeaderBoard leader;
	
	public int getId() {
		return player_ID;
	}
	public void setId(int id) {
		this.player_ID = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getIsdev() {
		return isdev;
	}
	public void setIsdev(String isdev) {
		this.isdev = isdev;
	}
	@Override
	public String toString() {
		return "Player [Player_ID=" + player_ID + ", Username=" + username + ", Password=" + password + ", Score="
				+ score + ", Firstname=" + firstname + ", Lastname=" + lastname + ", isdev=" + isdev + ", leader="
				+ leader + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((isdev == null) ? 0 : isdev.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + player_ID;
		result = prime * result + score;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Player other = (Player) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (isdev == null) {
			if (other.isdev != null)
				return false;
		} else if (!isdev.equals(other.isdev))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (player_ID != other.player_ID)
			return false;
		if (score != other.score)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}