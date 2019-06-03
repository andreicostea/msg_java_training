import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BugsTableComponentComponent } from './bugs-table-component.component';

describe('BugsTableComponentComponent', () => {
  let component: BugsTableComponentComponent;
  let fixture: ComponentFixture<BugsTableComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BugsTableComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BugsTableComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
