/*@author Jake Mulrenin, Max Couch*/
/**
 * The ts for the app component is found here. It contains a title 
 * for the front page as well as importing globals to access the global
 * variables and functions.
 */
import { Component } from '@angular/core';
import { Globals } from './global';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front-page';
  constructor(private globals:Globals){
    
  }
}