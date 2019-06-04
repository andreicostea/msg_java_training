import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PermissionManagerInsertComponent} from './permission-manager.containers.component';

describe('PermissionManagerContainersComponent', () => {
  let component: PermissionManagerInsertComponent;
  let fixture: ComponentFixture<PermissionManagerInsertComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PermissionManagerInsertComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermissionManagerInsertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
