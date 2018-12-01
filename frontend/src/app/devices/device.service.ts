import { Injectable } from '@angular/core';
import {Device} from '../models/Device';
// import {mock_devices} from '../models/mock-devices';
import {Observable, of} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {
  // devices: Device[] = mock_devices;
  private devicesUrl = 'http://localhost:8080/devices';

  constructor(private http: HttpClient) { }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(this.devicesUrl);
  }

  private temp: Observable<Device>;
  addDevice(device: Device): Observable<Device>{  // workInProgress ***
    console.log("service.addDevice invoked");
    console.log(this.temp = this.http.post<Device>(this.devicesUrl + '/add', device))
    return this.temp;  
  }
}

