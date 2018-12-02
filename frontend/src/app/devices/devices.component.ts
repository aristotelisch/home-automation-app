import { Component, OnInit } from '@angular/core';
import {Device} from '../models/Device';
//import {mock_devices} from '../models/mock-devices';
import {DeviceService} from './device.service';

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

  
  addDevice(id: number, name: string, status: boolean, type: string, information: string) { 
    let device = new Device(id, name, status, type, information); 
    //this.devices.push(device); 
    this.deviceService.addDevice(device).subscribe(value => device = value);   // workInProgress ***
    this.devices.push(device); 
    console.log("service.addDevice returned");
    console.log(device);
  }
  removeDevice() {  
    //let index = this.devices.indexOf(device); 
    //this.devices.splice(index,1);
  }
  updateDevice() {  
    //
  }

}

