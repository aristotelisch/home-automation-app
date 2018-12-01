import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DevicesComponent } from './devices/devices.component';
import { HttpClientModule } from '@angular/common/http';
import { HomePageComponent } from './home-page/home-page.component';
import { KitchenDevicesComponent } from './kitchen-devices/kitchen-devices.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { LivingroomDevicesComponent } from './livingroom-devices/livingroom-devices.component';
import { BedroomDevicesComponent } from './bedroom-devices/bedroom-devices.component';
import { BathroomDevicesComponent } from './bathroom-devices/bathroom-devices.component';
import { GarageDevicesComponent } from './garage-devices/garage-devices.component';
import { YardDevicesComponent } from './yard-devices/yard-devices.component';
import { AdminTablesComponent } from './admin-tables/admin-tables.component';
import { RoomComponent } from './room/room.component';

@NgModule({
  declarations: [
    AppComponent,
    DevicesComponent,
    HomePageComponent,
    KitchenDevicesComponent,
    LoginPageComponent,
    AdminPageComponent,
    LivingroomDevicesComponent,
    BedroomDevicesComponent,
    BathroomDevicesComponent,
    GarageDevicesComponent,
    YardDevicesComponent,
    AdminTablesComponent,
    RoomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
