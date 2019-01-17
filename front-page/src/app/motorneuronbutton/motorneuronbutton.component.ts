/**
 * @author Jake Mulrenin
 */
/*The diabetes button component shows the motor neuron disease option. When the button is clicked, 
the function, checkDisease(), checks whether or not the chosen disease is correct or not.
If the disease is correct, the current health is added to the player's score. If not,
health is set to 0 and the score is not changed. It also increments the patient number 
that is used to determine when the game is finished as well as displays the newpatient
button.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-motorneuronbutton',
  templateUrl: './motorneuronbutton.component.html',
  styleUrls: ['./motorneuronbutton.component.css']
})
export class MotorneuronbuttonComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  checkDisease(){
    if(this.globals.data.disease.disease_name == "Motor Neuron Disease"){
      this.globals.score += this.globals.health;
      document.getElementById("rightOrWrong").innerHTML = "You guessed the correct diagnosis! " + this.globals.health + " points awarded!";
    }else{
      this.globals.health = 0;
      this.globals.score += 0;
      document.getElementById("rightOrWrong").innerHTML = "You're diagnosis is incorrect! " + this.globals.health + " points awarded.";
    }
      this.globals.showNewPatientButton = true;
      this.globals.numPatients++;
  }
}
