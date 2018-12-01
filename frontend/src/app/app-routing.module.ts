import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DevicesComponent} from './devices/devices.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RoomsComponent } from './rooms/home-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/authenticate',  pathMatch: 'full' },
  { path: 'authenticate', component: LoginPageComponent },
  { path: 'rooms', component: RoomsComponent, pathMatch: 'full' },
  { path: 'devices', component: DevicesComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
