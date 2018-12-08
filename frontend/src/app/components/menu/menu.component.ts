import { Component, OnInit } from '@angular/core';
import {AppService} from '../../services/app.service';
import {User} from '../../models/User';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  user: User;

  constructor(private app: AppService) { }

  ngOnInit() {
    console.log(this.app.getUser());
    this.user = this.app.getUser();
  }

}
