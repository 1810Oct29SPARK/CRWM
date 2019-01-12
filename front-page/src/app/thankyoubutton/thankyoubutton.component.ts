import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';

@Component({
  selector: 'app-thankyoubutton',
  templateUrl: './thankyoubutton.component.html',
  styleUrls: ['./thankyoubutton.component.css']
})
export class ThankyoubuttonComponent implements OnInit {

  constructor(public globals:Globals) { }

  ngOnInit() {
  }
  introducePatient(){
    this.globals.patientFirstName = "Sally";
    this.globals.patientLastName = "Brooks";
    document.getElementById("introPatient").innerHTML += "> Great! I'd like to introduce you to your new patient, " + this.globals.patientFirstName + " " + this.globals.patientLastName;
    this.globals.sleep(2500).then(() => {document.getElementById("patientGreeting").innerHTML += "> It's nice to meet you Dr. " + this.globals.username + ". I hope you can help me."});
    this.globals.sleep(5000).then(() => {document.getElementById("userGreeting").innerHTML += "It's nice to meet you, " + this.globals.patientFirstName + ". Well, let's get started."});
    this.globals.firstButtonOn = false;
    this.globals.sleep(7500).then(() => {this.globals.whichTestButton = true});
  }
}
