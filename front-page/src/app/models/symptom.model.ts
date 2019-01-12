import { HttpClient } from '@angular/common/http';

export class Symptom {
     id: number;
     name: string;
     description: string;
     observable: string;
     testable: string;
     test: string;
     constructor(id: number, name: string, description: string, observable: string, testable: string, test: string){
         this.id = id;
         this.name = name;
         this.description = description;
         this.observable = observable;
         this.testable = testable;
         this.test = test;
     }
 }