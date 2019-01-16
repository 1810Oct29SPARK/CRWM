/**
 * @author Max Couch
 */

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-leaderboard',
  templateUrl: './leaderboard.component.html',
  styleUrls: ['./leaderboard.component.css']
})
export class LeaderboardComponent implements OnInit {

  constructor(public globals: Globals) { }

  highScoreData = this.globals.highScoreData;

  ngOnInit() {
  }

}
