import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Http} from '@angular/http';
import {DeviceService} from './device.service';
import {Room} from '../models/Room';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RoomsService {

  private roomsUrl = 'http://localhost:8080/rooms';

  constructor(private http: HttpClient) { }

  getRooms(): Observable<Room[]>  {
    return this.http.get<Room[]>(this.roomsUrl);
  }
}
