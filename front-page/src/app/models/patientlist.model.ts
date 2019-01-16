import {Patient} from '../models/patient.model';

export class PatientList {
    patient: Patient[];
    constructor(patient:Patient[])
    {
        this.patient = patient;
    }
}