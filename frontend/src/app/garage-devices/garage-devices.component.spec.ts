import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GarageDevicesComponent } from './garage-devices.component';

describe('GarageDevicesComponent', () => {
  let component: GarageDevicesComponent;
  let fixture: ComponentFixture<GarageDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GarageDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GarageDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
