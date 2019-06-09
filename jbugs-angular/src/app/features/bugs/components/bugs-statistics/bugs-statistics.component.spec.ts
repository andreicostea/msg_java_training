import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BugsStatisticsComponent } from './bugs-statistics.component';

describe('BugsStatisticsComponent', () => {
  let component: BugsStatisticsComponent;
  let fixture: ComponentFixture<BugsStatisticsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BugsStatisticsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BugsStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
