import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-profile-button',
  templateUrl: './profile-button.component.html',
  styleUrls: ['./profile-button.component.css']
})
export class ProfileButtonComponent implements OnInit {
  constructor(public globals:Globals, public activatedRoute:ActivatedRoute) { }
  
  ngOnInit() {
    this.globals.isDev = this.globals.data.isdev;
    console.log(this.globals.isDev);
  }
}