import { Component } from '@angular/core';
import { AppService } from './services/app.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {User} from './models/User';
import {Observable} from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Home Automation App';
  logoutUrl = 'http://localhost:8080/logout';
  authenticated = false;
  user: User;

  constructor(private app: AppService, private http: HttpClient, private router: Router) {

    if (sessionStorage.getItem('token')) {
      this.app.authenticate(undefined);
      this.authenticated = this.app.authenticated;
    }
  }

  setCurrentuser() {
    this.app.getUser();
  }


}
