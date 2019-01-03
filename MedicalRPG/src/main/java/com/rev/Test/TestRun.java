package com.rev.Test;

import com.rev.Beans.Credentials;
import com.rev.Dao.PlayerDao;
import com.rev.DaoImpl.PlayerDaoImpl;
import com.rev.Service.AuthenticationService;
import com.rev.Singleton.Single;

public class TestRun {
	
	public static void main (String[] args) {
		Single.instance().Dummy();
		PlayerDao use = new PlayerDaoImpl();
		AuthenticationService auth = new AuthenticationService();
		Credentials cred = new Credentials("kboden0@google.com","qn36JJ6E9ov");
		System.out.println(auth.isValidUser(cred));
		/*List<Player> players = new ArrayList<>();
		players = use.getallPlayers();
		for(Player p:players) {
		System.out.println(p);
		}
		Player testPlayer = new Player(10400, "ebaker@yahoo.com","password","Emanuel","Baker",11111,"false");
		use.deletePlayer(testPlayer);
		*/
		
	}

}
