import {Component, Input, OnInit} from '@angular/core';
import {Room} from '../../models/Room';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  @Input()
  room: Room[];

  constructor() { }

  ngOnInit() {
  }

  showDevices(room: Room): void {

  }

}
