/**
 * @author Jake Mulrenin 
 */
/*The clipboard component displays the area in which important information regarding 
the patient is stored. It contains a function that toggles the ngIf statement used 
to change the view between the patient information and the disease cheat sheet.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-clipboard',
  templateUrl: './clipboard.component.html',
  styleUrls: ['./clipboard.component.css']
})
export class ClipboardComponent implements OnInit {
  patientFirstName;
  patientLastName;
  constructor(public globals: Globals, public http: HttpClient) { }
  ngOnInit() {
  }

  toggleDiagnosis() {
    if (this.globals.showDiagnosisCheatSheet == false) {
      this.globals.showDiagnosisCheatSheet = true;
    } else {
      this.globals.showDiagnosisCheatSheet = false;
    }
  }
}


