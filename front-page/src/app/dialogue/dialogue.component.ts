/**
 * @author Jake Mulrenin
 */
/*The dialogue component outlines the area on the game page that deals with displaying
the conversations between the lead doctor, the player, and the patients. The .ts file 
contains a function that displays the first message of the game once the game page starts.
It also contains the call to Java that sends the score data to be updated in the database.*/

import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dialogue',
  templateUrl: './dialogue.component.html',
  styleUrls: ['./dialogue.component.css']
})
export class DialogueComponent implements OnInit {

  constructor(private globals: Globals, public http: HttpClient, public route: Router) { }
  ngOnInit() {
    this.startGame();
  }

  updateScore() {
    let newScore = JSON.stringify(this.globals.score);
    this.http.put("http://localhost:9999/MedicalRPG/score", {
      'username': this.globals.username,
      'score': newScore
    }).subscribe((result) => {
    });
    // this.route.navigate(['/playerPage']);
    
  }

  startGame() {
    document.getElementById("dialoguetext").innerHTML = this.globals.introStart + this.globals.username + "." + this.globals.introEnd;
    this.globals.sleep(2000).then(() => { this.globals.beginGame = true; })
  }
}
