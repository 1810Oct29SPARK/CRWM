import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { GamePageComponent } from './game-page/game-page.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'game', component: GamePageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
