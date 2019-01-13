import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-observebutton',
  templateUrl: './observebutton.component.html',
  styleUrls: ['./observebutton.component.css']
})
export class ObservebuttonComponent implements OnInit {
  observeButtonOn:boolean = true;
  constructor(private globals: Globals) { }

  ngOnInit() {
  }

  observePatient(){
    document.getElementById("observation").innerHTML = "> Okay, I just want to take a moment to check you over to see any noticable symptoms.";
    this.globals.observableSymptom = this.globals.data.disease.symptom[0].symptom_Name;
    this.globals.sleep(3000).then(() => this.globals.observableSymptom = "extensive sweating");
    this.globals.sleep(4000).then(() => {document.getElementById("observationConclusion").innerHTML = this.globals.observation + this.globals.observableSymptom});
    this.observeButtonOn = false;
  }
}
