import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YardDevicesComponent } from './yard-devices.component';

describe('YardDevicesComponent', () => {
  let component: YardDevicesComponent;
  let fixture: ComponentFixture<YardDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YardDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YardDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
