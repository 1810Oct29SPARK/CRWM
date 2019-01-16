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
