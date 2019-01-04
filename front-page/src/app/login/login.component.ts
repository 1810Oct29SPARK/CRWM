import { Component, OnInit,Inject } from '@angular/core';
import { Globals } from '../global';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  private isOn:boolean;
  constructor(private globals:Globals) {
    this.isOn = globals.isOn;
   }

  ngOnInit() {
  }

//   $('.message a').click(function () {
//     $('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
// });

}
