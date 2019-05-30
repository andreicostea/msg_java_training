import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BugAddComponent } from './bug-add.component';

describe('BugAddComponent', () => {
  let component: BugAddComponent;
  let fixture: ComponentFixture<BugAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BugAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BugAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
