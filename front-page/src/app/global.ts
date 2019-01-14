/*@author Jake Mulrenin */
/*This global ts file defines the isOn variable that is used to 
change the views depending on what is clicked on*/
import{Injectable} from "@angular/core";
import { HttpClient } from '@angular/common/http';


@Injectable()
export class Globals{
    constructor(public http: HttpClient){}
    isOn:boolean = true;
    firstButtonOn = true;
    whichTestButton1 = false;
    whichTestButton2 = false;
    whichTestButton3 = false;
    introStart:string = "> Welcome,  ";
    introEnd:string = "I'm Dr. Hawk. Congratulations  on  passing  medical  school! Now  your  real  test  begins.";
    username:string;
    patientFirstName:string;
    patientLastName:string;
    observableSymptom:string;
    observation:string = "You notice ";
    data;
    isDiagnosed: boolean = false;
    questionSymptom:string;
    testSymptom:string;
    whichTest:string;
    showDiagnosisCheatSheet:boolean = false;
    health:number = 100;
    showDiseaseOptions = false;
    score:number = 0;
    showNewPatient:boolean = false;
    restartTheGame:boolean = false;
    beginGame:boolean = false;
    showNewPatientButton = false;
    
    sleep (time) {
        return new Promise((resolve) => setTimeout(resolve, time));
      }
      loadData(id:number){
        this.http.get(`http://localhost:9999/MedicalRPG/${id}`).subscribe(data => {
            this.data = data;
            console.log(data);
        });

      }
    
      random(){
        return Math.floor(Math.random() * 3) + 1;
      }

      restartGame(){
        this.loadData(this.random());
        document.getElementById("dialoguetext").innerHTML = 'Another patient has walked in!';
        document.getElementById("introPatient").innerHTML = '';
        document.getElementById("patientGreeting").innerHTML = '';
        document.getElementById("userGreeting").innerHTML = '';
        document.getElementById("observation").innerHTML = '';
        document.getElementById("observationConclusion").innerHTML = '';
        document.getElementById("question").innerHTML = '';
        document.getElementById("questionResponse").innerHTML = '';
        document.getElementById("test").innerHTML = '';
        document.getElementById("testResults").innerHTML = '';
        document.getElementById("rightOrWrong").innerHTML = '';
        this.beginGame = true;
        this.health = 100;
        this.firstButtonOn = true;
        this.whichTestButton1 = false;
        this.showDiseaseOptions = false;
        this.restartTheGame = false;
        this.showNewPatientButton = false;
        this.patientFirstName = '';
        this.patientLastName = '';
        this.observableSymptom = '';
        this.questionSymptom = '';
        this.testSymptom = '';
      }
}