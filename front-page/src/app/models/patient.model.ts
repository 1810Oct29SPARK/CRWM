import {Disease} from './disease.model';

export class Patient {
    id: number;
    firstName: string;
    lastName: string;
    age: number;
    disease: Disease;

    constructor(id: number, firstName: string, lastName: string, age: number, disease: Disease){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.disease = disease;
    }
}