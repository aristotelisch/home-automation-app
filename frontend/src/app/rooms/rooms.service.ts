import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Http} from '@angular/http';
import {DeviceService} from '../devices/device.service';
import {Room} from '../models/room';
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
