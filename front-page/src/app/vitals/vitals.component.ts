/*The vitals component is responsible for displaying the vitals along with the patient's 
current health.*/

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
  }

}
