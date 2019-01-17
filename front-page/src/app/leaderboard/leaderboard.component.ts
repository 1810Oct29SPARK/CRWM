/**
 * @author Max Couch
 */
/*The leaderboard component will interpolate the information about the top 5 players 
in the database based on their score and lists them in descending order on the profile 
pages. */
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
