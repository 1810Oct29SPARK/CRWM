/*@author Jake Mulrenin */
/*This global ts file defines the isOn variable that is used to 
change the views depending on what is clicked on*/
import{Injectable} from "@angular/core";

@Injectable()
export class Globals{
    isOn:boolean = true;
    setIsOn(value){
        this.isOn = value;
    }
    getIsOn(){
        return this.isOn;
    }
}