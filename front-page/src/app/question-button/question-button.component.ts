import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-question-button',
  templateUrl: './question-button.component.html',
  styleUrls: ['./question-button.component.css']
})
export class QuestionButtonComponent implements OnInit {

  constructor(public globals: Globals) {}

  ngOnInit() {
    
  }

  questionPatient(){
    for (var i = 0; i < 3; i++){
      if (this.globals.data.disease.symptom[i].isDialogue == 'yes'){
        this.globals.questionSymptom = this.globals.data.disease.symptom[i].symptom_Name;
        document.getElementById("question").innerHTML = "> How have you been feeling?";
        this.globals.sleep(4000).then(() => {document.getElementById("questionResponse").innerHTML = "> Well, doctor, I've been experiencing " + this.globals.questionSymptom});
      }
    }
    this.globals.health -= 20;
  }

}
