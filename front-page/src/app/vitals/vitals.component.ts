/*This ts file outlines the constructor for the vitals component
on the game page*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-vitals',
  templateUrl: './vitals.component.html',
  styleUrls: ['./vitals.component.css']
})
export class VitalsComponent implements OnInit {
  health:number = 100;
  constructor(public globals: Globals) { }

  ngOnInit() {
    this.globals.sleep(10000);
    this.decreaseHealth();
  }

  decreaseHealth(){
    while(!this.globals.isDiagnosed){
      this.globals.sleep(3000);
      this.health -= 1;
      return this.health;
    }
  }
}
