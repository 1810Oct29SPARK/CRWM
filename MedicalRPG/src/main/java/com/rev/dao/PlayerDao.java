package com.rev.dao;

import java.util.List;

import com.rev.beans.Player;

public interface PlayerDao {
	public Player getPlayerByID(int id);
	public List<Player> getallPlayers();
	public List<Player> getPlayersByHighScore();
	public void updatePlayer(Player player);
	public void addPlayer(Player player);
	public void deletePlayer(Player player);
	public Player findPlayerByUsername(String username);
}