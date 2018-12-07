import { Component, OnInit } from '@angular/core';
import {Device} from '../../models/Device';
import {Room} from '../../models/Room';
//import {mock_devices} from '../models/mock-devices';
import {DeviceService} from '../../services/device.service';
import { Observable } from 'rxjs';
import { RoomsService } from 'src/app/services/rooms.service';
import { forEach } from '@angular/router/src/utils/collection';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})

export class DevicesComponent implements OnInit {

  devices: Device[] = [];
  rooms: Room[] = [];
  selectedRoomId: number;

  constructor(private deviceService: DeviceService,
              private roomService: RoomsService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    this.getDevices();
    this.getRooms();
  }

  onRoomSelect() {
    console.log(this.selectedRoomId);
  }

  onRoomUpdate(device){
    console.log(device);
    //console.log(id);
    //device.setRoomId(id);
    //console.log(id);
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

  /**
   * Unlike the device's attributes, we get roomId via selectedRoomId's double binding.
   */
  addDevice(name: string, status: boolean, type: string, information: string) {
    const device = new Device(-1, name, status, type, information, this.selectedRoomId);
    this.deviceService.addDevice(device).subscribe(value => this.devices = value);   // Remove device.id from UI
    //this.devices.push(device); 
  }

  removeDevice(device: Device) {
    this.deviceService.removeDevice(device.id).subscribe(value => this.devices = value);   // refresh page after any request ***
    // console.log(this.rooms);
    return;
  }

  updateDevice(device: Device) {
    this.deviceService.updateDevice(device).subscribe(value => this.devices = value);
    this.addSingleMessagePopUp('info', 'Device updated', '');
    return;
  }


  addSingleMessagePopUp(severity, summary, detail) {
    this.messageService.add({severity: severity, summary: summary, detail: detail});
    setTimeout(() => {
      console.log('hide');
      this.clearMessagePopUp();
    }, 3000);
  }

  clearMessagePopUp() {
    this.messageService.clear();
  }

}

