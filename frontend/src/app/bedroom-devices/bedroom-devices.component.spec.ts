import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BedroomDevicesComponent } from './bedroom-devices.component';

describe('BedroomDevicesComponent', () => {
  let component: BedroomDevicesComponent;
  let fixture: ComponentFixture<BedroomDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BedroomDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BedroomDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
