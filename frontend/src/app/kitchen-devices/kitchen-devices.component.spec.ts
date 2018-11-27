import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KitchenDevicesComponent } from './kitchen-devices.component';

describe('KitchenDevicesComponent', () => {
  let component: KitchenDevicesComponent;
  let fixture: ComponentFixture<KitchenDevicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KitchenDevicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KitchenDevicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
