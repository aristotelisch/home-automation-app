import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DevicesComponent } from './components/devices/devices.component';
import { AuthenticateComponent } from './components/authenticate/authenticate.component';
import { RoomsComponent } from './components/rooms/rooms.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {LoginGuard} from './auth/login.guard';
import {ManageRoomsComponent} from './components/manage-rooms/manage-rooms.component';
import {ManageUsersComponent} from './components/manage-users/manage-users.component';
import {ManageDevicesComponent} from './components/manage-devices/manage-devices.component';

const routes: Routes = [
  { path: '', redirectTo: 'dashboard',  pathMatch: 'full' },
  { path: 'dashboard', component: DashboardComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'authenticate', component: AuthenticateComponent, pathMatch: 'full' },
  { path: 'rooms', component: RoomsComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'devices', component: DevicesComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  { path: 'devices/:id', component: DevicesComponent, canActivate: [LoginGuard], pathMatch: 'full' },
  {
    path: 'admin',
    children: [
      { path: 'users', component: ManageUsersComponent, canActivate: [LoginGuard], pathMatch: 'full' },
      { path: 'rooms', component: ManageRoomsComponent, canActivate: [LoginGuard], pathMatch: 'full' },
      { path: 'devices', component: ManageDevicesComponent, canActivate: [LoginGuard], pathMatch: 'full' },
    ]
  },

  { path: '**', redirectTo: 'dashboard' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: false })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
