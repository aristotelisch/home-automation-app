import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';

@Injectable()
export class AppService {

  user: User;
  userUrl = 'http://localhost:8080/user';
  authHeaders = {};

  authenticated = false;

  constructor(private http: HttpClient) {
    // this.user = new User('Telis', true);
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
      console.log('inside authenticate method');
      console.log(response);
      console.log(response['authenticated'] === true);
      if (response['authenticated'] === true) {
        this.authenticated = true;
        this.saveAuthHeaders(headers);
        console.log('this.authenticated is ', this.authenticated);
      } else {
        this.authenticated = false;
      }
      console.log(this.authenticated);
      return callback && callback();
    });

  }

  private saveAuthHeaders(headers: HttpHeaders) {
    this.authHeaders = headers;
  }

}
