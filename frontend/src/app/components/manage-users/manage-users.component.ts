import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/user.service';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.css']
})
export class ManageUsersComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    this.getUsers();
  }

  getUsers(): void {
    this.userService.getUsers().subscribe(data => this.users = data);
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
