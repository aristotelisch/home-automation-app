import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';

@Injectable()
export class AppService {

  user: User;

  authenticated = false;

  constructor(private http: HttpClient) {

    this.user = new User('Telis', true);
  }

  getUser(): User {
    return this.user;
  }

  authenticate(credentials, callback) {

    const headers = new HttpHeaders(credentials ? {
      authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get('user', {headers: headers}).subscribe(response => {
      if (response['name']) {
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    });

  }

}
