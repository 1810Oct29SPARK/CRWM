package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Player;
import com.rev.daoimpl.PlayerDaoImpl;

/**
 * This service will check the users credentials all of the players
 * As soon as the operation finds a name and password that matches one 
 * in the data base it will return that players information
 * @author Darius
 *
 */
@Service
public class LoginService {
	public Player isValidUser(String username, String password) {
		PlayerDaoImpl playin = new PlayerDaoImpl();
		Player play = null;
		List<Player> playList = playin.getallPlayers();
		if (username != null && password != null) {
			for (Player p : playList) {
				if (username.equals(p.getUsername()) && password.equals(p.getPassword())) {
					play = p;
					return play;
				}
			}
		}
		return play;
	}
}