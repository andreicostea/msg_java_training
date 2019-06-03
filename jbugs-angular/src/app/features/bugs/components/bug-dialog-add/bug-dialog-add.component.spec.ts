import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BugDialogAddComponent } from './bug-dialog-add.component';

describe('BugDialogAddComponent', () => {
  let component: BugDialogAddComponent;
  let fixture: ComponentFixture<BugDialogAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BugDialogAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BugDialogAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
