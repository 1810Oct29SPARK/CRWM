package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Player;
import com.rev.dao.PlayerDao;
import com.rev.daoimpl.PlayerDaoImpl;

/**
 * The player service will get all the player dao methods
 * @author Darius
 *
 */
@Service
public class PlayerService {

	PlayerDao pdao = new PlayerDaoImpl();

	public List<Player> getAllPlayers() {
		return pdao.getallPlayers();
	}
	
	public List<Player> getPlayersByHighScore() {
		return pdao.getPlayersByHighScore();
	}

	public Player getPlayer(int id) {
		return pdao.getPlayerByID(id);
	}

	public void addPlayer(Player player) {
		pdao.addPlayer(player);
	}

	public void removePlayer(Player player) {
		pdao.deletePlayer(player);
	}

	public void updatePlayer(Player player) {
		pdao.updatePlayer(player);
	}
	/*
	 * Find player will let us find a by its username
	 * We want to use this instead of id so that the dev can never see the player id
	 * We will use this same method service in delete update and find player inside of our controllers
	 */
	public Player findPlayer(String username) {
		PlayerDaoImpl playin = new PlayerDaoImpl();
		Player play = null;
		List<Player> playList = playin.getallPlayers();
		if (username != null) {
			for (Player p : playList) {
				if (username.equals(p.getUsername())) {
					play = p;
					System.out.println(play);
					return play;
				}
			}
		}
		return play;
	}
}
