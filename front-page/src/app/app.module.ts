/*@author Jake Mulrenin, Max Couch*/
/**
 * This is the ts file for the module of the app component
 * all of the imports are found here, as well as the providers,
 * bootstrapping, and declarations.
 */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DialogueComponent } from './dialogue/dialogue.component';
import { VitalsComponent } from './vitals/vitals.component';
import { ClipboardComponent } from './clipboard/clipboard.component';
import { LoginComponent } from './login/login.component';
import { Globals } from './global';
import { GamePageComponent } from './game-page/game-page.component';
import { ThankyoubuttonComponent } from './thankyoubutton/thankyoubutton.component';
import { WrongHospitalButtonComponent } from './wrong-hospital-button/wrong-hospital-button.component';
import { ObservebuttonComponent } from './observebutton/observebutton.component';
import { TestbuttonComponent } from './testbutton/testbutton.component';
import { QuestionButtonComponent } from './question-button/question-button.component';
import { DiagnosebuttonComponent } from './diagnosebutton/diagnosebutton.component';
import { DiabetesbuttonComponent } from './diabetesbutton/diabetesbutton.component';
import { LeukemiabuttonComponent } from './leukemiabutton/leukemiabutton.component';
import { MalariabuttonComponent } from './malariabutton/malariabutton.component';
import { LaryngitisbuttonComponent } from './laryngitisbutton/laryngitisbutton.component';
import { FibromyalgiabuttonComponent } from './fibromyalgiabutton/fibromyalgiabutton.component';
import { MotorneuronbuttonComponent } from './motorneuronbutton/motorneuronbutton.component';
import { PlayerPageComponent } from './player-page/player-page.component';
import { DevprofileComponent } from './devprofile/devprofile.component';

@NgModule({
  declarations: [
    AppComponent,
    DialogueComponent,
    VitalsComponent,
    ClipboardComponent,
    LoginComponent,
    GamePageComponent,
    ThankyoubuttonComponent,
    WrongHospitalButtonComponent,
    ObservebuttonComponent,
    TestbuttonComponent,
    QuestionButtonComponent,
    DiagnosebuttonComponent,
    DiabetesbuttonComponent,
    LeukemiabuttonComponent,
    MalariabuttonComponent,
    LaryngitisbuttonComponent,
    FibromyalgiabuttonComponent,
    MotorneuronbuttonComponent,
    PlayerPageComponent,
    DevprofileComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [Globals, ThankyoubuttonComponent, ClipboardComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
