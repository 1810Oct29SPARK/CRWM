import { Component, OnInit } from '@angular/core';
import {Globals} from '../global';

@Component({
  selector: 'app-dialogue',
  templateUrl: './dialogue.component.html',
  styleUrls: ['./dialogue.component.css']
})
export class DialogueComponent implements OnInit {

  constructor(private globals:Globals) { }
  beginGame:boolean = false;
  ngOnInit() {
    this.startGame();
  }

  startGame(){
    document.getElementById("dialoguetext").innerHTML = this.globals.introStart + this.globals.username + "." + this.globals.introEnd;
    this.globals.sleep(2000).then(() => {this.beginGame = true;})
  }
}
