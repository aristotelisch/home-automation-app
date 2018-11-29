import { Component, OnInit } from '@angular/core';
import {Device} from '../models/Device';
import {mock_devices} from '../models/mock-devices';
import {DeviceService} from '../device.service';

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

  //
  addDevice() { 
    let device = new Device(); 
    this.devices.push(device); 
  }
  removeDevice() {  
    //let index = this.devices.indexOf(device); 
    //this.devices.splice(index,1);
  }
  updateDevice() {  
    //
  }

}

