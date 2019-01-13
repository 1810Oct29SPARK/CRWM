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
  constructor(private globals:Globals, public http: HttpClient) { }
  ngOnInit(){
  }
}


