import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-devprofile',
  templateUrl: './devprofile.component.html',
  styleUrls: ['./devprofile.component.css']
})
export class DevprofileComponent implements OnInit {

  constructor(public globals:Globals, public activatedRoute:ActivatedRoute) { }

  ngOnInit() {
    this.loadUsername();
  }
  loadUsername(){
    this.globals.username = this.activatedRoute.snapshot.queryParams.username;
    console.log(this.globals.username);
}
}
