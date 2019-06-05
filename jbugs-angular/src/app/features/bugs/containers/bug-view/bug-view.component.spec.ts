import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BugViewComponent } from './bug-view.component';

describe('BugViewComponent', () => {
  let component: BugViewComponent;
  let fixture: ComponentFixture<BugViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BugViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BugViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
