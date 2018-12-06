import { Component, OnInit } from '@angular/core';
import {Device} from '../../models/Device';
import {Room} from '../../models/Room';
//import {mock_devices} from '../models/mock-devices';
import {DeviceService} from '../../services/device.service';
import { Observable } from 'rxjs';
import { RoomsService } from 'src/app/services/rooms.service';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})

export class DevicesComponent implements OnInit {

  devices: Device[] = [];
  
  rooms: Room[] = [];
  selectedRoom: any;

  constructor(private deviceService: DeviceService, private roomService: RoomsService) { }

  ngOnInit() {
    this.getDevices();
    this.getRooms();
  }

  onRoomSelect(event){
    console.log(this.selectedRoom);
    console.log(this.selectedRoom.name);
  }
  
  getDevices(): void {
    this.deviceService.getDevices().subscribe(value => this.devices = value);
  }

  getRooms(): void {
    this.roomService.getRooms().subscribe(value => this.rooms = value);
  }

  /** 
   * All BackEnd Controllers return the full list of Devices, so as to refresh the admin's screen.
   */

  addDevice(id: number, name: string, status: boolean, type: string, information: string) { 
    let device = new Device(id, name, status, type, information); 
    this.deviceService.addDevice(device).subscribe(value => this.devices = value);   // Remove device.id from UI
    //this.devices.push(device); 
  }

  removeDevice(device: Device) {  
    this.deviceService.removeDevice(device.id).subscribe(value => this.devices = value);   // refresh page after any request ***
    // console.log(this.rooms);
    return; // maybe inform someone the device has been deleted ???
  }
  
  updateDevice(device: Device) {  
    this.deviceService.updateDevice(device).subscribe(value => this.devices = value);
    return;
  }

}

