import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
// import { DevicesComponent } from './devices/devices.component';
import { DevicesComponent } from './components/devices/devices.component';
import { RoomsComponent } from './rooms/rooms.component';
import { AuthenticateComponent } from './components/authenticate/authenticate.component';
import { RoomComponent } from './room/room.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MenuComponent } from './components/menu/menu.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import {FormsModule} from '@angular/forms';
import {AppService} from './services/app.service';


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
