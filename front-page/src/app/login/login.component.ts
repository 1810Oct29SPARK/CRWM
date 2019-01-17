/**
 * @author Jake Mulrenin
 */
/*The login component simply is used to display and style the login page. The login and 
registration forms are set up to send http requests to the server side to either add 
a player to the database or log the player into either the player or dev page.*/


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