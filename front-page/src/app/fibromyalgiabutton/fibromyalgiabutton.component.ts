import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-fibromyalgiabutton',
  templateUrl: './fibromyalgiabutton.component.html',
  styleUrls: ['./fibromyalgiabutton.component.css']
})
export class FibromyalgiabuttonComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  checkDisease(){
    if(this.globals.data.disease.disease_name == "Fibromyalgia"){
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
