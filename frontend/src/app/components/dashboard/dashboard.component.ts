import { Component, OnInit } from '@angular/core';
import {AppService} from '../../services/app.service';
import {User} from '../../models/User';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user: User;
  authenticated = true;

  constructor(private app: AppService) { }

  ngOnInit() {
    this.user = this.app.getUser();
    this.authenticated = this.app.authenticated;
    console.log(this.authenticated);
  }

}
