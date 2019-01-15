package com.rev.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rev.beans.Player;
import com.rev.dao.PlayerDao;
import com.rev.daoimpl.PlayerDaoImpl;

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
	public Player findPlayer(String username) {
		PlayerDaoImpl playin = new PlayerDaoImpl();
		Player play = null;
		List<Player> playList = playin.getallPlayers();
		if (username != null) {
			for (Player p : playList) {
				if (username.equals(p.getUsername())) {
					play = p;
					return play;
				}
			}
		}
		return play;
	}
}
