import { Injectable } from '@angular/core';
import {Device} from '../models/Device';

// import {mock_devices} from '../models/mock-devices';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Room} from '../models/Room';
import {AppService} from './app.service';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  private devicesUrl = 'http://localhost:8080/devices';
  private usersUrl = 'http://localhost:8080/users';

  private temp: Observable<Device>;
  private status: boolean;

  constructor(private http: HttpClient, private app: AppService) { }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.usersUrl + '/' + this.app.getUser().name + '/devices' , { headers: this.app.authHeaders } );
  }

  getAllDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.devicesUrl , { headers: this.app.authHeaders } );
  }

  addDevice(device: Device): Observable<Device[]> {
    return this.http.post<Device[]>(this.devicesUrl, device, { headers: this.app.authHeaders } );
  }

  removeDevice(id: number): Observable<Device[]> {
    return this.http.delete<Device[]>(this.devicesUrl + '/' + id, { headers: this.app.authHeaders });
  }

  updateDevice(device: Device): Observable<Device[]> {
    return this.http.put<Device[]>(this.devicesUrl, device, { headers: this.app.authHeaders } );
  }
}
