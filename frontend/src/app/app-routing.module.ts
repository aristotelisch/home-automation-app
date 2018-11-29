import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DevicesComponent} from './devices/devices.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminTablesComponent } from './admin-tables/admin-tables.component';
import { HomePageComponent } from './home-page/home-page.component';
import { KitchenDevicesComponent } from './kitchen-devices/kitchen-devices.component';
import { LivingroomDevicesComponent } from './livingroom-devices/livingroom-devices.component';
import { BedroomDevicesComponent } from './bedroom-devices/bedroom-devices.component';
import { BathroomDevicesComponent } from './bathroom-devices/bathroom-devices.component';
import { GarageDevicesComponent } from './garage-devices/garage-devices.component';
import { YardDevicesComponent } from './yard-devices/yard-devices.component';

const routes: Routes = [

  { path: '', redirectTo: '/login',  pathMatch: 'full'},
  { path: 'login', component: LoginPageComponent },
  { path: 'admin', component: AdminPageComponent },
  //{ path: 'admin/tables', component: DevicesComponent, pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'home/kitchen', component: KitchenDevicesComponent },
  { path: 'home/livingroom', component: LivingroomDevicesComponent },
  { path: 'home/bedroom', component: BedroomDevicesComponent },
  { path: 'home/bathroom', component: BathroomDevicesComponent },
  { path: 'home/garage', component: GarageDevicesComponent },
  { path: 'home/yard', component: YardDevicesComponent },

  //
  { path: 'devices', component: DevicesComponent, pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }