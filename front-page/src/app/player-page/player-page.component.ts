/**
 * @author Max Couch
 */
/*This player-page component is responsible for supplying and styling the non-developer 
profile page. It calls the loadLeaderboard() function when the view is displayed so 
that the leaderboard can be populated.*/

import { Component, OnInit } from '@angular/core';
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
  }

}
