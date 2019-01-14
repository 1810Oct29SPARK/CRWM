package com.rev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rev.beans.Player;
import com.rev.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private PlayerService playerservices;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	// @ResponseBody
	public ResponseEntity<List<Player>> getAllPlayers() {
		return new ResponseEntity<>(playerservices.getAllPlayers(), HttpStatus.OK);
	}
	
	@GetMapping(value="/highscore")
	public ResponseEntity<List<Player>> getPlayersByHighScore() {
		return new ResponseEntity<>(playerservices.getPlayersByHighScore(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	// @ResponseBody
	public ResponseEntity<Player> getPlayerbyID(@PathVariable int id) {
		Player p = playerservices.getPlayer(id);
		if (p == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/add")
	// @ResponseBody
	public ResponseEntity<String> addPlayer(@RequestBody Player player) {
		ResponseEntity<String> resp = null;
		try {
			playerservices.addPlayer(player);
			resp = new ResponseEntity<>("You Have Now Registered", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Failed to register try again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@PutMapping(value = "/update")
	// @ResponseBody
	public ResponseEntity<String> updatePlayer(@RequestBody Player player) {
		ResponseEntity<String> resp = null;
		try {
			playerservices.updatePlayer(player);
			resp = new ResponseEntity<>("You Have Now Updated", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Failed to update try again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}

	@DeleteMapping(value = "/delete")
	// @ResponseBody
	public ResponseEntity<String> deletePlayer(@RequestBody Player player) {
		ResponseEntity<String> resp = null;
		try {
			playerservices.removePlayer(player);
			resp = new ResponseEntity<>("You Have Deleted User", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<>("Failed to remove try again", HttpStatus.BAD_REQUEST);
		}
		return resp;
	}
}
