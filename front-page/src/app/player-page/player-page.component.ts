import { Component, OnInit } from '@angular/core';
import { Player } from '../models/player.model';
import { HttpClient } from '@angular/common/http';
import { Globals } from '../global';

@Component({
  selector: 'app-player-page',
  templateUrl: './player-page.component.html',
  styleUrls: ['./player-page.component.css']
})
export class PlayerPageComponent implements OnInit {

  constructor(public globals:Globals) { }

  ngOnInit() {
    this.globals.loadLeaderboard();
    console.log(this.globals.highScoreData);
  }

}
