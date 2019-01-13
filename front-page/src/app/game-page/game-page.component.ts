import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-game-page',
  templateUrl: './game-page.component.html',
  styleUrls: ['./game-page.component.css']
})
export class GamePageComponent implements OnInit {
  data;
  id:number;
  constructor(public globals: Globals, public http: HttpClient) { }

  ngOnInit() {
    this.globals.patientFirstName = '';
    this.globals.patientLastName = '';
    this.globals.observableSymptom = '';
    this.globals.isOn = true;
    this.globals.firstButtonOn = true;
    this.globals.whichTestButton = false;
    console.log(this.globals.patientFirstName);
    this.id = this.globals.random();
    this.globals.loadData(this.id);
  }
}
