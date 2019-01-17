package com.rev.dao;

import java.util.List;

import com.rev.beans.Player;

/**
 * @author Max Couch
 * 
 *         This creates basic CRUD methods as well as 2 specialties: One for
 *         sorting players by their scores descending, and another for finding
 *         players by their usernames. Please refer to Impl for specifics.
 */

public interface PlayerDao {
	public Player getPlayerByID(int id);

	public List<Player> getallPlayers();

	public List<Player> getPlayersByHighScore();

	public void updatePlayer(Player player);

	public void addPlayer(Player player);

	public void deletePlayer(Player player);

	public Player findPlayerByUsername(String username);
}