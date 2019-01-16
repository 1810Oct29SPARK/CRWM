/**
 * @author Max Couch
 */

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
