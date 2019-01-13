package com.rev.beans;

/**
 * Summary * This object will take in the user input Taking in the username an
 * password that the user enters Later we will authenticate the users input
 * against the information in the database
 * 
 * @author Darius
 */
public class Credentials {

	public Credentials(String username, String password) {
		super();

		this.username = username;
		this.password = password;
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setEmail(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", Password=" + password + "]";
	}
}