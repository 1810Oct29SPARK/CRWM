/**
 * @author Darius Watts
 */
/*The dev profile displays the view for the developer page whenever a dev logs in. 
It fetches players data from the global function loadPlayers() and displays them on the page.
It will also grab the query params for username, and the dev's name and sets them to 
the global variables.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-devprofile',
  templateUrl: './devprofile.component.html',
  styleUrls: ['./devprofile.component.css']
})
export class DevprofileComponent implements OnInit {

  constructor(public globals: Globals, public activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.loadUsername();
    this.globals.loadPlayers();
  }
  loadUsername() {
    this.globals.username = this.activatedRoute.snapshot.queryParams.username;
    this.globals.playerFirstName = this.activatedRoute.snapshot.queryParams.firstname;
    this.globals.playerLastName = this.activatedRoute.snapshot.queryParams.lastname;
}
}
