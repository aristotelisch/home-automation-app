import { Component, OnInit } from '@angular/core';
import { RoomsService } from 'src/app/services/rooms.service';
import { MessageService } from 'primeng/api';
import { Room } from 'src/app/models/Room';

@Component({
  selector: 'app-manage-rooms',
  templateUrl: './manage-rooms.component.html',
  styleUrls: ['./manage-rooms.component.css']
})
export class ManageRoomsComponent implements OnInit {

  rooms: Room[] = [];
  
  constructor(private roomService: RoomsService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    this.getRooms();
  }

  getRooms(): void {
    this.roomService.getRooms().subscribe(value => this.rooms = value);
  }

  addRoom(name: string, image: string) {
    const room = new Room(-1, name, image);
    this.roomService.addRoom(room).subscribe(value => this.rooms = value);   // Remove device.id from UI
    //this.devices.push(device); 
  }

  removeRoom(room: Room) {
    this.roomService.removeRoom(room.id).subscribe(value => this.rooms = value);   // refresh page after any request ***
    // console.log(this.rooms);
    return;
  }

  updateRoom(room: Room) {
    this.roomService.updateRoom(room).subscribe(value => this.rooms = value);
    this.addSingleMessagePopUp('info', 'Room updated', '');
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
