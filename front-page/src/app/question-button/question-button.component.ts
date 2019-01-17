/**
 * @author Jake Mulrenin
 */
/*The question button is responsible for displaying the conversation following when 
the player wants to "question" the patient. The function, questionPatient(), checks
which symptom is the question one and displays it to the dialogue page after a 
series of dialogue. It also decrements the patients health by 20.*/

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
