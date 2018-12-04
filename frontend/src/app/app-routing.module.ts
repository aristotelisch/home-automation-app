import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DevicesComponent } from './components/devices/devices.component';
import { AuthenticateComponent } from './components/authenticate/authenticate.component';
import { RoomsComponent } from './rooms/rooms.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {LoginGuard} from './auth/login.guard';

const routes: Routes = [
  { path: '', redirectTo: '/authenticate',  pathMatch: 'full' },
  { path: 'authenticate', component: AuthenticateComponent },

  { path: 'dashboard', component: DashboardComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'rooms', component: RoomsComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'devices', component: DevicesComponent, canActivate: [LoginGuard], pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
