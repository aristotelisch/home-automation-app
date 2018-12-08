import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { DevicesComponent } from './components/devices/devices.component';
import { RoomsComponent } from './components/rooms/rooms.component';
import { AuthenticateComponent } from './components/authenticate/authenticate.component';
import { RoomComponent } from './components/room/room.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { MenuComponent } from './components/menu/menu.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { BreadcrumbComponent } from './components/breadcrumb/breadcrumb.component';
import {FormsModule} from '@angular/forms';
import {AppService} from './services/app.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';
import {MessageService} from 'primeng/api';
import { ManageRoomsComponent } from './components/manage-rooms/manage-rooms.component';
import { ManageUsersComponent } from './components/manage-users/manage-users.component';
import { ManageDevicesComponent } from './components/manage-devices/manage-devices.component';
import { DashboardRoomsComponent } from './components/dashboard-rooms/dashboard-rooms.component';
import { DashboardDevicesComponent } from './components/dashboard-devices/dashboard-devices.component';
import { DeviceComponent } from './components/device/device.component';


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
    ManageRoomsComponent,
    ManageUsersComponent,
    ManageDevicesComponent,
    DashboardRoomsComponent,
    DashboardDevicesComponent,
    DeviceComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MessagesModule,
    MessageModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AppService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
