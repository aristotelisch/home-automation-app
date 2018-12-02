import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminTablesComponent } from './admin-tables.component';

describe('AdminTablesComponent', () => {
  let component: AdminTablesComponent;
  let fixture: ComponentFixture<AdminTablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminTablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminTablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
