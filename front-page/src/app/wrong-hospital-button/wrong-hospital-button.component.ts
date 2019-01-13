import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-wrong-hospital-button',
  templateUrl: './wrong-hospital-button.component.html',
  styleUrls: ['./wrong-hospital-button.component.css']
})
export class WrongHospitalButtonComponent implements OnInit {

  constructor(public globals: Globals) { }
  ngOnInit() {
  }

  wrongHospital(){
    document.getElementById("introPatient").innerHTML += "I'm  sorry,  sir.  I  don't  want  to  be  a  doctor  anymore.";
    this.globals.firstButtonOn=false;
  }
}
