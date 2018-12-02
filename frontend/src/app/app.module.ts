import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { DevicesComponent } from './devices/devices.component';
import { RoomsComponent } from './rooms/rooms.component';
import { AuthenticateComponent } from './authenticate/authenticate.component';
import { RoomComponent } from './room/room.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { BreadcrumbComponent } from './breadcrumb/breadcrumb.component';
import {FormsModule} from '@angular/forms';
import {AppService} from './app.service';

@NgModule({
  declarations: [
    AppComponent,
    AuthenticateComponent,
    DashboardComponent,
    DevicesComponent,
    // DeviceComponent TODO
    RoomsComponent,
    RoomComponent,
    MenuComponent,
    FooterComponent,
    HeaderComponent,
    BreadcrumbComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
