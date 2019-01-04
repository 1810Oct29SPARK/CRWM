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
