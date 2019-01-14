package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Credentials;
import com.rev.beans.Player;
import com.rev.daoimpl.PlayerDaoImpl;

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