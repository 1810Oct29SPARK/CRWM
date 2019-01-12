/*@author Jake Mulrenin */
/*This global ts file defines the isOn variable that is used to 
change the views depending on what is clicked on*/
import{Injectable} from "@angular/core";
import { HttpClient } from '@angular/common/http';

@Injectable()
export class Globals{
    isOn:boolean = true;
    firstButtonOn = true;
    whichTestButton = false;
    showName = false;
    introStart:string = "> Welcome,  ";
    introEnd:string = "I'm Dr. Hawk. Congratulations  on  passing  medical  school! Now  your  real  test  begins.";
    username:string = "CapnKnuckles";
    patientFirstName:string;
    patientLastName:string;
    observableSymptom:string;
    observation:string = "You notice ";
    data;
    isDiagnosed: boolean = false;
     
    constructor(public http: HttpClient){}
    sleep (time) {
        return new Promise((resolve) => setTimeout(resolve, time));
      }
      loadData(id:number){
        this.http.get(`http://localhost:9999/MedicalRPG/${id}`).subscribe(data => {
            this.data = data;
            console.log(data);
            this.patientFirstName = this.data.first_Name;
            this.patientLastName = this.data.last_Name;
            this.observableSymptom = this.data.disease.symptom[0].symptom_Name;
        });

      }
    
      random(){
        return Math.floor(Math.random() * 3) + 1;
      }
}