import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardDevicesComponent } from './dashboard-devices.component';

describe('DashboardDevicesComponent', () => {
  let component: DashboardDevicesComponent;
  let fixture: ComponentFixture<DashboardDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
