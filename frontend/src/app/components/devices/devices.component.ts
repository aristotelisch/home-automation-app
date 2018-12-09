import { Component, OnInit } from '@angular/core';
import {Device} from '../../models/Device';
import {Room} from '../../models/Room';
import {DeviceService} from '../../services/device.service';
import { Observable } from 'rxjs';
import { RoomsService } from 'src/app/services/rooms.service';
import { forEach } from '@angular/router/src/utils/collection';
import {MessageService} from 'primeng/api';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-devices',
  templateUrl: './devices.component.html',
  styleUrls: ['./devices.component.css']
})

export class DevicesComponent implements OnInit {

  devices: Device[] = [];
  rooms: Room[] = [];
  selectedRoomId: number;
  roomId: number;


  constructor(private route: ActivatedRoute,
              private deviceService: DeviceService,
              private roomService: RoomsService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    this.roomId = this.getRoomId();
    this.roomId ? this.getDevicesByRoomId(this.roomId) : this.getDevices();
  }

  getRoomId(): number {
    return +this.route.snapshot.paramMap.get('id');
  }

  getDevices(): void {
    // console.log("Should not here!!");
    this.deviceService.getDevices().subscribe(value => this.devices = value);
  }

  getDevicesByRoomId(roomId: number){
    this.deviceService.getDevicesByRoomId(roomId).subscribe(value => this.devices = value);
  }

  // onRoomSelect() {
  //   console.log(this.selectedRoomId);
  // }

  // onRoomUpdate(device){
  //   console.log(device);
  // }

  // updateDevice(device: Device) {
  //   this.deviceService.updateDevice(device).subscribe(value => this.devices = value);
  //   this.addSingleMessagePopUp('info', 'Device updated', '');
  //   return;
  // }


  // addSingleMessagePopUp(severity, summary, detail) {
  //   this.messageService.add({severity: severity, summary: summary, detail: detail});
  //   setTimeout(() => {
  //     console.log('hide');
  //     this.clearMessagePopUp();
  //   }, 3000);
  // }

  // clearMessagePopUp() {
  //   this.messageService.clear();
  // }

}

