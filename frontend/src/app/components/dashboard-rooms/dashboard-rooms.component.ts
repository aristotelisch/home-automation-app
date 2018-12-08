import { Component, OnInit } from '@angular/core';
import {Room} from '../../models/Room';
import {RoomsService} from '../../services/rooms.service';

@Component({
  selector: 'app-dashboard-rooms',
  templateUrl: './dashboard-rooms.component.html',
  styleUrls: ['./dashboard-rooms.component.css']
})
export class DashboardRoomsComponent implements OnInit {

  rooms: Room[] = [];

  constructor(private roomService: RoomsService) { }

  ngOnInit() {
    this.getRooms();
  }

  getRooms(): void {
    this.roomService.getRooms().subscribe(data => this.rooms = data);
  }
}
