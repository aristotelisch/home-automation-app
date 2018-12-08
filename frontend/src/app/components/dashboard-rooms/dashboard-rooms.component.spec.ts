import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardRoomsComponent } from './dashboard-rooms.component';

describe('DashboardRoomsComponent', () => {
  let component: DashboardRoomsComponent;
  let fixture: ComponentFixture<DashboardRoomsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardRoomsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardRoomsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
