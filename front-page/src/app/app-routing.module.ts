import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GamePageComponent } from './game-page/game-page.component';
import {DevprofileComponent} from '../app/devprofile/devprofile.component';
import { PlayerPageComponent } from './player-page/player-page.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'game', component: GamePageComponent},
<<<<<<< HEAD
  {path: 'playerPage', component: PlayerPageComponent}
=======
  {path: 'devprofile', component: DevprofileComponent},
  {path: 'player', component: PlayerPageComponent}
>>>>>>> 388eeff2205c72bdfd73cd963e0c3e814a52751a
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
