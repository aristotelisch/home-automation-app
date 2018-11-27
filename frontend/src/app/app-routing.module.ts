import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DevicesComponent} from './devices/devices.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { HomePageComponent } from './home-page/home-page.component';
import { KitchenDevicesComponent } from './kitchen-devices/kitchen-devices.component';

const routes: Routes = [

  { path: '', redirectTo: '/login',  pathMatch: 'full'},
  { path: 'login', component: LoginPageComponent },
  { path: 'admin', component: AdminPageComponent },
  { path: 'home', component: HomePageComponent },
  { path: 'home/kitchen', component: KitchenDevicesComponent },

  //
  { path: 'devices', component: DevicesComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }