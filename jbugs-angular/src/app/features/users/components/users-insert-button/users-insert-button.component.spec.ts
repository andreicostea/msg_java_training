import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersInsertButtonComponent } from './users-insert-button.component';

describe('UsersInsertButtonComponent', () => {
  let component: UsersInsertButtonComponent;
  let fixture: ComponentFixture<UsersInsertButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersInsertButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersInsertButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
