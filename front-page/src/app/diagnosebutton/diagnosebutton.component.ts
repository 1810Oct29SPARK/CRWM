import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-diagnosebutton',
  templateUrl: './diagnosebutton.component.html',
  styleUrls: ['./diagnosebutton.component.css']
})
export class DiagnosebuttonComponent implements OnInit {

  constructor(public globals: Globals) { }

  ngOnInit() {
  }

  diagnosePatient(){
    this.globals.showDiseaseOptions = true;
  }
}
