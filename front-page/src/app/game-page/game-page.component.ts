/**
 * @author Jake Mulrenin
 */

import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { Globals } from '../global';
@Component({
  selector: 'app-game-page',
  templateUrl: './game-page.component.html',
  styleUrls: ['./game-page.component.css']
})
export class GamePageComponent implements OnInit {
  data;
  id:number;
  constructor(public globals: Globals, public http: HttpClient, public activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.globals.patientFirstName = '';
    this.globals.patientLastName = '';
    this.globals.observableSymptom = '';
    this.globals.isOn = true;
    this.globals.firstButtonOn = true;
    this.globals.whichTestButton1 = false;
    this.globals.whichTestButton2 = false;
    this.globals.whichTestButton3 = false;
    this.id = this.globals.random();
    this.globals.loadData(this.id);
    this.globals.questionSymptom = '';
    this.globals.testSymptom = '';
    this.globals.whichTest='';
    this.globals.showDiagnosisCheatSheet = false;
    this.globals.health = 100;
    this.globals.showDiseaseOptions = false;
    this.globals.showNewPatient = false;
    this.globals.restartTheGame = false;
    this.globals.numPatients = 0;
  }

  loadUsername(){
          this.globals.username = this.activatedRoute.snapshot.queryParams.username;
          console.log(this.globals.username);
  }
}