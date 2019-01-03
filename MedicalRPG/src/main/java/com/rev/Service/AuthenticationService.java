package com.rev.Service;


import java.util.List;

import com.rev.Beans.Credentials;
import com.rev.Beans.Player;
import com.rev.Dao.PlayerDao;
import com.rev.DaoImpl.PlayerDaoImpl;



public class AuthenticationService {
	//public EmployeeDao empl = new EmployeeDaoImpl();
	public Player isValidUser(Credentials cred)
	{
		PlayerDao playin = new PlayerDaoImpl();
		String user = cred.getEmail();
		String pass = cred.getPassword();
		Player play = null;
		List<Player> playList = playin.getallPlayers();
		if(user != null && pass != null)
		{
			for(Player p : playList){
				if(user.equals(p.getEmail()) && pass.equals(p.getPassword()))
				{					
					play = p;
					return play;
				}
			}
		}
		return play;					
	}
}