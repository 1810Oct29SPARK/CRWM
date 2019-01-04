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