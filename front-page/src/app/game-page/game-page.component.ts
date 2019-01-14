import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../models/patient.model';
import { Globals } from '../global';
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
    this.globals.whichTestButton1 = false;
    this.globals.whichTestButton2 = false;
    this.globals.whichTestButton3 = false;
    console.log(this.globals.patientFirstName);
    this.id = this.globals.random();
    this.globals.loadData(this.id);
    this.globals.questionSymptom = '';
    this.globals.testSymptom = '';
    this.globals.whichTest='';
  }
}