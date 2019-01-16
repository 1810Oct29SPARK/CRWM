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
