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
  constructor(public globals:Globals, public http: HttpClient) { }
  ngOnInit(){
  }

  toggleDiagnosis(){
    if(this.globals.showDiagnosisCheatSheet == false){
    this.globals.showDiagnosisCheatSheet = true;
    }else{
      this.globals.showDiagnosisCheatSheet = false;
    }
  }
}


