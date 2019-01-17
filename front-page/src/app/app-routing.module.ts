/**
 * @author Jake Mulrenin, Max Couch
 */
/*The app-routing module is responsible for defining the endpoints that can be called 
to change the display on the SPA.*/

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GamePageComponent } from './game-page/game-page.component';
import { DevprofileComponent } from '../app/devprofile/devprofile.component';
import { PlayerPageComponent } from './player-page/player-page.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'game', component: GamePageComponent },
  { path: 'devprofile', component: DevprofileComponent },
  { path: 'playerPage', component: PlayerPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
