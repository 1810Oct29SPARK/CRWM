/**
 * @author Max Couch
 */
/*The all-players component grabs the player data from the globals service. It then 
displays the first 4 players given by the data and displays them on the player pages.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-all-players',
  templateUrl: './all-players.component.html',
  styleUrls: ['./all-players.component.css']
})
export class AllPlayersComponent implements OnInit {

  constructor(public globals:Globals) { }

  playerData = this.globals.playerData;

  ngOnInit() {
  }

}
