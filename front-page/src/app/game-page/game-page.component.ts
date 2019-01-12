import { Component, OnInit } from '@angular/core';
import { Globals } from '../global';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-game-page',
  templateUrl: './game-page.component.html',
  styleUrls: ['./game-page.component.css']
})
export class GamePageComponent implements OnInit {
  data;
  id:number;
  constructor(public globals: Globals, public http: HttpClient) { }

  ngOnInit() {
    this.id = this.random();
  }
  loadData(){
    this.http.get('http://localhost:9999/MedicalRPG/1').subscribe(data => {
        this.data = data;
    })
  }

  random(){
    return Math.floor(Math.random() * 3) + 1;
  }
}
