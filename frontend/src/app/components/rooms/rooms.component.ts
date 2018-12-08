import { Component, OnInit } from '@angular/core';
import {DeviceService} from '../../services/device.service';
import {RoomsService} from '../../services/rooms.service';
import {Room} from '../../models/Room';
import {headersToString} from 'selenium-webdriver/http';


@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrls: ['./rooms.component.css']
})
export class RoomsComponent implements OnInit {

  rooms: Room[] = [];

  constructor(private roomService: RoomsService) { }

  ngOnInit() {
    this.getRooms();
  }

  getRooms(): void {
    this.roomService.getRooms().subscribe(data => this.rooms = data);
  }

  getDevices(room: Room): void {
    this.roomService.getDevices(room).subscribe(data =>
      this.rooms = data);
  }

}
