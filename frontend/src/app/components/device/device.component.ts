import {Component, Input, OnInit} from '@angular/core';
import {Device} from '../../models/Device';
import {DeviceService} from '../../services/device.service';
import {MessageService} from 'primeng/api';

@Component({
  selector: 'app-device',
  templateUrl: './device.component.html',
  styleUrls: ['./device.component.css']
})
export class DeviceComponent implements OnInit {
  @Input() device: Device;
  checked: boolean;

  constructor(private deviceService: DeviceService,
              private messageService: MessageService
  ) { }

  ngOnInit() {
    this.checked = this.device.status;
  }

  handleChange(e) {
    this.device.status = e.checked;
    console.log(this.device);
    this.deviceService.updateSingleDevice(this.device).subscribe(value => this.device = value);

    this.addSingleMessagePopUp('info', 'Device updated', '');
    console.log(e.checked);
  }

  addSingleMessagePopUp(severity, summary, detail) {
    this.messageService.add({severity: severity, summary: summary, detail: detail});
    setTimeout(() => {
      console.log('hide');
      this.clearMessagePopUp();
    }, 3000);
  }

  clearMessagePopUp() {
    this.messageService.clear();
  }
}
