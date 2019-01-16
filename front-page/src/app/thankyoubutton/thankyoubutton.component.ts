import { Component, OnInit } from '@angular/core';
import { Injectable } from "@angular/core";
import {Globals} from '../global';
import {GamePageComponent} from '../game-page/game-page.component';
import { injectRootLimpMode } from '@angular/core/src/di/injector_compatibility';

@Injectable()
@Component({
  selector: 'app-thankyoubutton',
  templateUrl: './thankyoubutton.component.html',
  styleUrls: ['./thankyoubutton.component.css']
})
export class ThankyoubuttonComponent implements OnInit {
  patientFirstName:string;
  patientLastName:string;
  constructor(public globals:Globals) { }

  ngOnInit() {
  }
  introducePatient(){
    this.globals.patientFirstName = this.globals.data.first_Name;
    this.globals.patientLastName = this.globals.data.last_Name;
    document.getElementById("introPatient").innerHTML = "> Great! I'd like to introduce you to your new patient, " + this.globals.patientFirstName + " " + this.globals.patientLastName;
    this.globals.sleep(2500).then(() => {document.getElementById("patientGreeting").innerHTML += "> It's nice to meet you Dr. " + this.globals.username + ". I hope you can help me."});
    this.globals.sleep(5000).then(() => {document.getElementById("userGreeting").innerHTML += "> It's nice to meet you, " + this.globals.patientFirstName + ". Well, let's get started."});
    this.globals.firstButtonOn = false;
    this.globals.sleep(7500).then(() => {this.globals.whichTestButton1 = true});
  }
}
