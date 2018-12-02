import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DevicesComponent } from './devices/devices.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { RoomsComponent } from './rooms/rooms.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: '', redirectTo: '/authenticate',  pathMatch: 'full' },
  { path: 'authenticate', component: AuthenticateComponent },
  { path: 'dashboard', component: DashboardComponent, pathMatch: 'full' },
  { path: 'rooms', component: RoomsComponent, pathMatch: 'full' },

  { path: 'devices', component: DevicesComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
