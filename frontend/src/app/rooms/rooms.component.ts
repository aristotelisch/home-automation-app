import { Component, OnInit } from '@angular/core';
import {DeviceService} from '../devices/device.service';
import {RoomsService} from './rooms.service';
import {Room} from '../models/room';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class RoomsComponent implements OnInit {

  rooms: Room[] = [];

  constructor(private roomService: RoomsService) { }

  ngOnInit() {
    // this.rooms = [
    //   { id: 1, name: 'Living Room', image: 'living_room.jpg' },
    //   { id: 2, name: 'Bed Room', image: 'bedroom.jpg' },
    // ];
    this.getRooms();
  }

  getRooms(): void {
    this.roomService.getRooms().subscribe(data => this.rooms = data);
  }

}
