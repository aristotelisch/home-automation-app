import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';
import {Router} from '@angular/router';
import {MessageService} from 'primeng/api';
import {Observable} from 'rxjs';

@Injectable()
export class AppService {

  user: User;
  userUrl = 'http://localhost:8080/user';
  authHeaders = {};

  authenticated = false;

  constructor(private http: HttpClient, private router: Router, private messageService: MessageService) {
  }

  setToken (token: string) {
    sessionStorage.setItem('token', token);
  }

  getToken(): string {
    return sessionStorage.getItem('token');
  }

  getUser(): User {
    return this.user;
  }

  setUser(user): void {
    this.user = user;
  }

  authenticate(callback) {

    const headers = new HttpHeaders({
      'Authorization': 'Basic ' + this.getToken()
    });

    console.log(headers);
    this.http.post(this.userUrl, null, { headers: headers}).subscribe(response => {
      if (response['authenticated'] === true) {
        this.authenticated = true;
        this.saveAuthHeaders(headers);
        const authority = response['authorities'][0]['authority'];
        let isAdmin = false;
        if (authority === 'ROLE_USER') {
          isAdmin = false;
        } else if (authority === 'ROLE_ADMIN') {
          isAdmin = true;
        }

        this.setUser(new User(response['name'], isAdmin));

      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }

  private saveAuthHeaders(headers: HttpHeaders) {
    this.authHeaders = headers;
  }

  logout() {
      this.authenticated = false;
      this.router.navigateByUrl('/authenticate');
        this.messageService.add({severity: 'warn', summary: 'You have been logged out', detail: ''});
        setTimeout(() => {
          console.log('hide');
          this.messageService.clear();
        }, 3000);
  }

}
