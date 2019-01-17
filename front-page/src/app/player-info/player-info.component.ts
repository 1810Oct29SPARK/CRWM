/**
 * @author Max Couch 
 * */ 
/*The player-info component will grab the player name and username from the query 
params and interpolates the values onto the page through a div element.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-player-info',
  templateUrl: './player-info.component.html',
  styleUrls: ['./player-info.component.css']
})
export class PlayerInfoComponent implements OnInit {

  constructor(public globals: Globals, public activatedRoute: ActivatedRoute) { }

  playerData = this.globals.playerData;

  ngOnInit() {
    this.loadPlayerData();
  }

  loadPlayerData() {
    this.globals.username = this.activatedRoute.snapshot.queryParams.username;
    this.globals.playerFirstName = this.activatedRoute.snapshot.queryParams.firstname;
    this.globals.playerLastName = this.activatedRoute.snapshot.queryParams.lastname;
  }
}
