package com.rev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.beans.Player;
import com.rev.service.LoginService;

/**
 * The Login Controller will take in the login information that the player
 * then it will go through the loginservice and autherize that the credentils the user input matches any refrences in the data base
 * finally if the information is returned properly we redirect the user to their profile page 
 * @author Darius
 *
 */
@Controller
public class LoginController {

	private LoginService autherize;

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.autherize = loginService;
	}
	
	/*
	 * When you try to go to the site naturaly it should send you to an incorrect page
	 */
	@GetMapping(value = "/auth")
	public String getStaticLogin(@RequestBody MultiValueMap<String, String> formParams, Model m) {	
		return handleForm(formParams,m);
	}

	/*
	 * This post method will take in the players username and password
	 * then it will authenticate the credentials against the database
	 * finaly we will send them to the angular proper profile page if the credentials are found
	 * the model will take in the information from the found player thus giving us their information
	 * if they are not it will return the user back to the login page
	 */
	@PostMapping(value = "/auth", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String handleForm(@RequestBody MultiValueMap<String, String> formParams, Model m) {
		System.out.println("form params recieved: " + formParams);
		Player cred = autherize.isValidUser(formParams.getFirst("login-username"),
				formParams.getFirst("login-password"));
		if (cred == null) {
			return "redirect:http://localhost:4200/login";
		} else {
			m.addAttribute("username", cred.getUsername());
			m.addAttribute("password", cred.getPassword());
			m.addAttribute("firstname", cred.getFirstname());
			m.addAttribute("lastname", cred.getLastname());
			m.addAttribute("score", cred.getScore());
			m.addAttribute("isdev", cred.getIsdev());
			if (cred.getIsdev().equals("false")) {
				return "redirect:http://localhost:4200/playerPage";
			} else {
				return "redirect:http://localhost:4200/devprofile";
			}
		}
	}
}
