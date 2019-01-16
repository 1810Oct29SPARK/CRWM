package com.rev.beans;

/**
 * Summary *
 * This object will take in the user input
 * Taking in the username an password that the user enters
 * Later we will authenticate the users input against the information in the database
 * @author Darius
 */
public class Credentials {

public Credentials( String username, String password) {
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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
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
	Credentials other = (Credentials) obj;
	if (username == null) {
		if (other.username != null)
			return false;
	} else if (!username.equals(other.username))
		return false;

	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}
@Override
public String toString() {
	return "Credentials [Email=" + username + ", Password=" + password + "]";
}
}