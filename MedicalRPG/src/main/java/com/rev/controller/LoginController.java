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

@Controller
public class LoginController {

	private LoginService autherize;

	@Autowired
	public LoginController(LoginService loginService) {
		super();
		this.autherize = loginService;
	}

	@GetMapping(value = "/login")
	public String getStaticLogin() {
		return "forward:/static/staticLogin.html";
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String handleForm(@RequestBody MultiValueMap<String, String> formParams, Model m) {
		System.out.println("form params recieved: " + formParams);

		Player cred = autherize.isValidUser(formParams.getFirst("username"), formParams.getFirst("password"));
		if (cred == null) {
			return "error";
		} else {
			m.addAttribute("username", cred.getUsername());
			m.addAttribute("score", cred.getScore());
			
			//m.addAttribute("pname", )
			return "profile";
		}
		
	}

}
