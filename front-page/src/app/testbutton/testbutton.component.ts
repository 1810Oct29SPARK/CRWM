/**
 * @author Jake Mulrenin
 */
/*The test button is responsible for displaying the conversation following when 
the player wants to "test" the patient. The function, testPatient(), checks
which symptom is the testable one, along with its test type, and displays them to the dialogue page after a 
series of dialogue. It also decrements the patients health by 40.*/

import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';

@Component({
  selector: 'app-testbutton',
  templateUrl: './testbutton.component.html',
  styleUrls: ['./testbutton.component.css']
})
export class TestbuttonComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  runTest(){
    for (var i = 0; i < 3; i++){
      if (this.globals.data.disease.symptom[i].is_Testable == 'yes'){
        this.globals.testSymptom = this.globals.data.disease.symptom[i].symptom_Name;
        this.globals.whichTest = this.globals.data.disease.symptom[i].symptom_Test;
      }
    }
    document.getElementById("test").innerHTML = "> I would like to run a " + this.globals.whichTest;
    if(this.globals.whichTest == 'Blood Test'){
      this.globals.sleep(4000).then(() => {document.getElementById("testResults").innerHTML = "> The " + this.globals.whichTest + " results have come back positive for " + this.globals.testSymptom});
    } else if (this.globals.whichTest == 'Colonoscopy'){
      this.globals.sleep(4000).then(() => {document.getElementById("testResults").innerHTML = "> The " + this.globals.whichTest + " results have come back positive for " + this.globals.testSymptom});
    } else {
      this.globals.sleep(4000).then(() => {document.getElementById("testResults").innerHTML = "> The " + this.globals.whichTest + " results have come back positive for " + this.globals.testSymptom});
    }
    this.globals.health -= 40;
  }

}
