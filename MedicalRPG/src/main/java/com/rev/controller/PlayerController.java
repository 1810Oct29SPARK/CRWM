package com.rev.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rev.beans.Player;
import com.rev.service.PlayerService;

/**
 * Player controller is in charge of sending and recieving player data
 * @author Darius
 *
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlayerController {
	@Autowired
	private PlayerService playerservices;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	// @ResponseBody
	public ResponseEntity<List<Player>> getAllPlayers() {
		return new ResponseEntity<>(playerservices.getAllPlayers(), HttpStatus.OK);
	}
	
	/*
	 * When a request is made this will return a list of players ordered by high score
	 */
	@GetMapping(value="/highscore")
	public ResponseEntity<List<Player>> getPlayersByHighScore() {
		return new ResponseEntity<>(playerservices.getPlayersByHighScore(), HttpStatus.OK);
	}

	/*
	 * When a get request is made this will return a player by thier id
	 */
	@GetMapping(value = "player/{id}")
	// @ResponseBody
	public ResponseEntity<Player> getPlayerbyID(@PathVariable int id) {
		Player p = playerservices.getPlayer(id);
		if (p == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}
	/*
	 * When a user sends a new username, password, firstname and lastname this method will take them
	 * and the user will be added to the database as well as being returned to the profile page
	 * If any of this information is null however it will return the user to the login page
	 */
	@PostMapping(value="/add",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addPlayer(@RequestParam String username,@RequestParam String password,
			@RequestParam String firstname,@RequestParam String lastname,Model m)
	{		
		if(username == null|| password == null||firstname== null||lastname ==null)
		{
			return "redirect:http://localhost:4200/login";
		}
		else
		{
			System.out.println(username+password+firstname+lastname);
			Player play = new Player(1,username,password, 0, firstname, lastname, "false");
			playerservices.addPlayer(play);
			m.addAttribute("firstname",firstname);
			m.addAttribute("lastname", lastname);
			m.addAttribute("username", username);
			m.addAttribute("password", password);
			m.addAttribute("score", play.getScore());
			m.addAttribute("isdev", play.getIsdev());
			return "redirect:http://localhost:4200/playerPage";
		}
	
	}
	/*
	 * This is a post request that will update the players information based on their inputs
	 * if any of the information is null it will return users to the login page
	 * Once the method has added the new information in the database it will return the user to the proper profile page
	 */
	@PostMapping(value = "/update",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// @ResponseBody
	public String updatePlayer(@RequestParam String updateusername,@RequestParam String username,@RequestParam String password,
			@RequestParam String firstname,@RequestParam String lastname,Model m)
	{	
		if(updateusername == null ||username == null|| password == null||firstname== null||lastname ==null)
		{
			return "redirect:http://localhost:4200/login";
		}
		else
		{
			System.out.println(username+password+firstname+lastname);
			Player play = playerservices.findPlayer(username);
			play.setUsername(updateusername);
			play.setFirstname(firstname);
			play.setLastname(lastname);
			play.setPassword(password);
			playerservices.updatePlayer(play);
			m.addAttribute("firstname",firstname);
			m.addAttribute("lastname", lastname);
			m.addAttribute("username", username);
			m.addAttribute("password", password);
			m.addAttribute("score", play.getScore());
			m.addAttribute("isdev", play.getIsdev());
			if(play.getIsdev() == "true")
			{
				return "redirect:http://localhost:4200/devprofile";
			}
			else
			{
				return "redirect:http://localhost:4200/playerPage";
			}
			
		}
	}
	/*
	 * This is a put request that will update the player in the database with a new score
	 * The information sent will be the player username and the score
	 * First the method will take find the player by their username then it will set the new score
	 */
	@PutMapping(value = "/score",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// @ResponseBody
	public String updateScore( @RequestParam MultiValueMap<String,String> formparam, Model m)
	{	
		if(formparam == null){
			return "redirect:http://localhost:4200/login";
		}
		else
		{
			System.out.println("form params recieved: " + formparam);
			int s = Integer.parseInt(formparam.getFirst("score"));
			Player play = playerservices.findPlayer(formparam.getFirst("username"));
			play.setScore(s);
			playerservices.updatePlayer(play);
			System.out.println(play);
			return "redirect:http://localhost:4200/login";
		}
	}
	/*
	 * This method will take in a player username then delete it
	 * If the username is incorrect the mehtod will return you to the login
	 * If the information is correct the method will return you to  login after deleting the player
	 */
	@PostMapping(value = "/delete",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	// @ResponseBody
	public String deletePlayer(@RequestParam String username, Model m) {
		System.out.println("form params recieved: " + username);
		Player play = playerservices.findPlayer(username);
		System.out.println(play);
		if(play == null)
		{
			return "redirect:http://localhost:4200/login";
		}else {
		playerservices.removePlayer(play);
		return "redirect:http://localhost:4200/login";
		}
	}
	/*
	 * This post method will find a player by their username then return thier information
	 */
	@PostMapping(value="/find", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Player FindPlayer(@RequestParam String username, Model m)
	{
		System.out.println("form param recieved: " + username);
		Player play = playerservices.findPlayer(username);
		m.addAttribute("firstname",play.getFirstname());
		m.addAttribute("lastname", play.getLastname());
		m.addAttribute("username", play.getUsername());
		m.addAttribute("password", play.getPassword());
		m.addAttribute("score", play.getScore());
		m.addAttribute("isdev", play.getIsdev());
		return play;
		
	}
}
