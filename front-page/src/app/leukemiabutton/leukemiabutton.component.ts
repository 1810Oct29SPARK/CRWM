import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-leukemiabutton',
  templateUrl: './leukemiabutton.component.html',
  styleUrls: ['./leukemiabutton.component.css']
})
export class LeukemiabuttonComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  checkDisease(){
    if(this.globals.data.disease.disease_name == "Leukemia"){
      this.globals.score += this.globals.health;
      document.getElementById("rightOrWrong").innerHTML = "You guessed the correct diagnosis! " + this.globals.health + " points awarded!";
    }else{
      this.globals.health = 0;
      this.globals.score += 0;
      document.getElementById("rightOrWrong").innerHTML = "You're diagnosis is incorrect! " + this.globals.health + " points awarded.";
    }
  }
}
