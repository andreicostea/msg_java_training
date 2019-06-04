import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {InsertorremovepermissionComponent} from './insert.component';

describe('InsertorremovepermissionComponent', () => {
  let component: InsertorremovepermissionComponent;
  let fixture: ComponentFixture<InsertorremovepermissionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [InsertorremovepermissionComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertorremovepermissionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
