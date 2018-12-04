import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BathroomDevicesComponent } from './bathroom-devices.component';

describe('BathroomDevicesComponent', () => {
  let component: BathroomDevicesComponent;
  let fixture: ComponentFixture<BathroomDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BathroomDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BathroomDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
