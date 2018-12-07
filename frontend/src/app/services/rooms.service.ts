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
}
