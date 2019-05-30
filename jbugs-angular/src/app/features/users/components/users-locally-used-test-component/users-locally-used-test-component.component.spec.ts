import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {UsersLocallyUsedTestComponentComponent} from './users-locally-used-test-component.component';

describe('UsersLocallyUsedTestComponentComponent', () => {
  let component: UsersLocallyUsedTestComponentComponent;
  let fixture: ComponentFixture<UsersLocallyUsedTestComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UsersLocallyUsedTestComponentComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersLocallyUsedTestComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
