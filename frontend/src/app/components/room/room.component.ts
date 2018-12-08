import {Component, Input, OnInit} from '@angular/core';
import {Room} from '../../models/Room';
import { Router } from '@angular/router';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {

  @Input()
  room: Room;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  showDevices(): void {
    this.router.navigate(['/devices/'+ this.room.id]);
    console.log("Should not have come here");
    return;
  }

}
