package com.rev.beans;

/**
 * 
 * @author Max Couch, Jake Mulrenin
 *
 *         This bean is for updating the player score. When the player presses
 *         "submit score" at the end of the game, it initializes the variables
 *         in angular with the new score, IF the score is higher than their
 *         previous
 */

public class UsernameScore {

	private String username;
	private String score;

	public UsernameScore(String username, String score) {
		super();
		this.username = username;
		this.score = score;
	}

	public UsernameScore() {
		super();
	}

	@Override
	public String toString() {
		return "UsernameScore [username=" + username + ", score=" + score + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
