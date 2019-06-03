import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersUpdateDialogComponent } from './users-update-dialog.component';

describe('UsersUpdateDialogComponent', () => {
  let component: UsersUpdateDialogComponent;
  let fixture: ComponentFixture<UsersUpdateDialogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UsersUpdateDialogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersUpdateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
