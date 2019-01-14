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
  constructor(public globals: Globals) { }

  ngOnInit() {
    this.globals.sleep(10000);
  }

}
