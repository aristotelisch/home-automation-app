import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Http} from '@angular/http';
import {DeviceService} from './device.service';
import {Room} from '../models/Room';
import {HttpClient} from '@angular/common/http';
import {AppService} from './app.service';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  private roomsUrl = 'http://localhost:8080/rooms';

  constructor(private http: HttpClient, private app: AppService) { }

  getRooms(): Observable<Room[]>  {
    return this.http.get<Room[]>(this.roomsUrl, { headers: this.app.authHeaders });
  }

  addRoom(room: Room): Observable<Room[]> {
    return this.http.post<Room[]>(this.roomsUrl, room, { headers: this.app.authHeaders });
  }

  removeRoom(id: number): Observable<Room[]> {
    return this.http.delete<Room[]>(this.roomsUrl + '/' + id, { headers: this.app.authHeaders });
  }

  updateRoom(room: Room): Observable<Room[]> {
    return this.http.put<Room[]>(this.roomsUrl, room, { headers: this.app.authHeaders } );
  }
}
