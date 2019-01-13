/*@author Jake Mulrenin, Max Couch*/
/**
 * This is the ts file for the module of the app component
 * all of the imports are found here, as well as the providers,
 * bootstrapping, and declarations.
 */
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DialogueComponent } from './dialogue/dialogue.component';
import { VitalsComponent } from './vitals/vitals.component';
import { ClipboardComponent } from './clipboard/clipboard.component';
import { LoginComponent } from './login/login.component';
import { Globals } from './global';
import { GamePageComponent } from './game-page/game-page.component';

@NgModule({
  declarations: [
    AppComponent,
    DialogueComponent,
    VitalsComponent,
    ClipboardComponent,
    LoginComponent,
    GamePageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [Globals],
  bootstrap: [AppComponent]
})
export class AppModule {
}
