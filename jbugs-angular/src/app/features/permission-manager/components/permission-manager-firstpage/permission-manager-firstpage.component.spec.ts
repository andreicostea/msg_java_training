import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {PermissionManagerInsertButtonComponent} from "./permission-manager-firstpage.component";

describe('PermissionManagerTestComponentComponent', () => {
  let component: PermissionManagerInsertButtonComponent;
  let fixture: ComponentFixture<PermissionManagerInsertButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [PermissionManagerInsertButtonComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PermissionManagerInsertButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
