import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {MessageService} from 'primeng/api';
import { Device } from 'src/app/models/Device';
import { DeviceService } from 'src/app/services/device.service';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.css']
})
export class ManageUsersComponent implements OnInit {
  users: User[] = [];
  devices: Device[] = [];

  constructor(private userService: UserService,
              private messageService: MessageService,
              private deviceService: DeviceService
  ) { }

  ngOnInit() {
    this.getUsers();
    this.getDevices();
  }

  


  getUsers(): void {
    this.userService.getUsers().subscribe(data => this.users = data);
  }

  getDevices(): void {
    this.deviceService.getDevices().subscribe(value => this.devices = value);
  }

  addUser(username: string, email: string, personname: string, password: string, surname: string) {
    let user = new User(username, false);
    user.username = username;
    user.email = email;
    user.personname = personname;
    user.password = password;
    user.personrole = 'ROLE_USER';

    this.userService.addUser(user).subscribe(value => this.users = value);
    this.addSingleMessagePopUp('info', 'User updated', '');
  }

  updateUser(user: User) {
    this.userService.updateUser(user).subscribe(value => this.users = value);
    this.addSingleMessagePopUp('info', 'User updated', '');
    return;
  }

  removeUser(user: User) {
    this.userService.removeUser(user.id).subscribe(value => this.users = value);
    this.addSingleMessagePopUp('info', 'User Deleted', '');
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
