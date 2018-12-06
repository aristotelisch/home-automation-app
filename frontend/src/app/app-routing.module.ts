import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DevicesComponent } from './components/devices/devices.component';
import { AuthenticateComponent } from './components/authenticate/authenticate.component';
import { RoomsComponent } from './rooms/rooms.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {LoginGuard} from './auth/login.guard';

const routes: Routes = [
  { path: '', redirectTo: 'dashboard',  pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'authenticate', component: AuthenticateComponent, pathMatch: 'full' },
  { path: 'rooms', component: RoomsComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'devices', component: DevicesComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: '**', redirectTo: 'dashboard' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: false })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
