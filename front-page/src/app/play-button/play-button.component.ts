/**
 * @author Max Couch
 */
/*The play-button component grabs the isDev variable from the query parameters and loads 
it into the isDev global variable. When the play button is clicked from the player 
profile pages, the application will route to the game page view.*/
import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-play-button',
  templateUrl: './play-button.component.html',
  styleUrls: ['./play-button.component.css']
})
export class PlayButtonComponent implements OnInit {

  constructor(public globals:Globals, public activatedRoute:ActivatedRoute) { }
  
  ngOnInit() {
    this.globals.isDev = this.activatedRoute.snapshot.queryParams.isDev;
  }

}
