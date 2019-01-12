import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Patient} from '../app/models/patient.model';
import { Observable } from 'rxjs';
import { PatientList } from './models/patientlist.model';
import {map} from 'rxjs/operators';
import 'rxjs/Rx';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private httpClient : HttpClient) { }
 getPatient(id:number):Observable<Patient>
 {
   return this.httpClient.get<Patient>(`http://localhost:9999/MedicalRPG/player/${id}`);
 }
 getAllPatient():Observable<PatientList>
 {
   return this.httpClient.get<PatientList>('http://localhost:9999/MedicalRPG/player')
   .map(
     (patients) =>{
     let patientData = patients;
     console.log(patientData);
     return patientData;
     })
   }
 }

