import { Component, OnInit } from '@angular/core';
import {User} from '../../models/User';
import {AppService} from '../../services/app.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentUser: User;

  constructor(private app: AppService, private router: Router) { }

  ngOnInit() {
    this.currentUser = this.app.getUser();
  }

  logout() {
      this.app.logout();
      this.router.navigateByUrl('/authenticate');
  }

}
