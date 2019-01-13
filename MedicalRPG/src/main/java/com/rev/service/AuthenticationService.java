package com.rev.service;

import java.util.List;

import com.rev.beans.Credentials;
import com.rev.beans.Player;
import com.rev.daoimpl.PlayerDaoImpl;

public class AuthenticationService {
	public Player isValidUser(Credentials cred)
	{
		PlayerDaoImpl playin = new PlayerDaoImpl();
		String user = cred.getUsername();
		String pass = cred.getPassword();
		Player play = null;
		List<Player> playList = playin.getallPlayers();
		if(user != null && pass != null)
		{
			for(Player p : playList){
				if(user.equals(p.getUsername()) && pass.equals(p.getPassword()))
				{					
					play = p;
					return play;
				}
			}
		}
		return play;					
	}
}