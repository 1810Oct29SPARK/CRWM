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

    for (var i = 0; i < 3; i++){
      if (this.globals.data.disease.symptom[i].is_Observable == 'yes'){
        this.globals.observableSymptom = this.globals.data.disease.symptom[i].symptom_Name;
        document.getElementById("observation").innerHTML = "> Okay, I just want to take a moment to check you over to see any noticable symptoms.";
        this.globals.sleep(4000).then(() => {document.getElementById("observationConclusion").innerHTML = this.globals.observation + this.globals.observableSymptom});    
      }
    }
    this.observeButtonOn = false;
    this.globals.health -= 10;
  }
}
