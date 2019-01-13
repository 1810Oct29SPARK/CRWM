import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Patient } from '../models/patient.model';
@Component({
  selector: 'app-game-page',
  templateUrl: './game-page.component.html',
  styleUrls: ['./game-page.component.css']
})
export class GamePageComponent implements OnInit {
  data;
  id:number;
  firstname;
  lastname;
  Disease;
  firstsymptom;
  secondsymptom;
  thirdsymptom;
  constructor(public http: HttpClient) { }

  ngOnInit() {
    this.id = this.random();
    this.loadPatientData(this.id);    
  }
  loadPatientData(id:number){
    this.http.get<Patient>(`http://localhost:9999/MedicalRPG/${id}`).subscribe(data => {
        this.data = data;
        this.firstname = this.data.first_Name;
        this.lastname = this.data.last_Name;
        this.Disease = this.data.disease.disease_name;
        this.firstsymptom = this.data.disease.symptom[0].symptom_Name;
        this.secondsymptom = this.data.disease.symptom[1].symptom_Name;
        this.thirdsymptom = this.data.disease.symptom[2].symptom_Name;
    })
  }
  random(){
    return Math.floor(Math.random() * 3) + 1;
  }
}