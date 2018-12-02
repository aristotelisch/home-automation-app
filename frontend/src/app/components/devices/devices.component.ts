import { Component, OnInit } from '@angular/core';
import {Device} from '../../models/Device';
//import {mock_devices} from '../models/mock-devices';
import {DeviceService} from '../../services/device.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})

export class DevicesComponent implements OnInit {
  devices: Device[] = [];

  constructor(private deviceService: DeviceService) { }

  ngOnInit() {
    this.getDevices();
  }
  
  getDevices(): void {
    this.deviceService.getDevices().subscribe(value => this.devices = value);
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
    return; // maybe inform someone the device has been deleted ???
  }
  
  updateDevice(device: Device) {  
    this.deviceService.updateDevice(device).subscribe(value => this.devices = value);
    return;
  }

}

