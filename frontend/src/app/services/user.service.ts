import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {AppService} from './app.service';
import {User} from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private usersUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient, private app: AppService) { }

  getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl, { headers: this.app.authHeaders } );
  }

  addUser(user: User): Observable<User[]> {
    return this.http.post<User[]>(this.usersUrl, user, { headers: this.app.authHeaders } );
  }

  removeUser(id: number): Observable<User[]> {
    return this.http.delete<User[]>(this.usersUrl + '/' + id, { headers: this.app.authHeaders });
  }

  updateUser(user: User): Observable<User[]> {
    return this.http.put<User[]>(this.usersUrl, user, { headers: this.app.authHeaders } );
  }
}
