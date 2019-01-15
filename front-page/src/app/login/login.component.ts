/*This .ts imports the Globals ts which contains the variable
"isOn" which is used to show and hide the login page depending 
on what is clicked*/


import { Component, OnInit,Inject } from '@angular/core';
import { Globals } from '../global';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private globals:Globals, public http:HttpClient) {
   }

  ngOnInit() {
  }
}