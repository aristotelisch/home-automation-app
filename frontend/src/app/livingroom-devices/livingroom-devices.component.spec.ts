import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LivingroomDevicesComponent } from './livingroom-devices.component';

describe('LivingroomDevicesComponent', () => {
  let component: LivingroomDevicesComponent;
  let fixture: ComponentFixture<LivingroomDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LivingroomDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LivingroomDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
