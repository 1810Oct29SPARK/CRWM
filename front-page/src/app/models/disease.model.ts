import { Symptom } from './symptom.model';

 export class Disease {
     id: number;
     name: string;
     description: string;
     symptom1: Symptom;
     symptom2: Symptom;
     symptom3: Symptom;

     constructor(id: number, name: string, description: string, symptom: Symptom, symptom2: Symptom, symptom3: Symptom){
         this.id = id;
         this.name = name;
         this.description = description;
         this.symptom1 = symptom;
         this.symptom2 = symptom2;
         this.symptom3 = symptom3;
     }
 }