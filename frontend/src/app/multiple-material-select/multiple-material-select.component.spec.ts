import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MultipleMaterialSelectComponent } from './multiple-material-select.component';

describe('MultipleMaterialSelectComponent', () => {
  let component: MultipleMaterialSelectComponent;
  let fixture: ComponentFixture<MultipleMaterialSelectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MultipleMaterialSelectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MultipleMaterialSelectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
