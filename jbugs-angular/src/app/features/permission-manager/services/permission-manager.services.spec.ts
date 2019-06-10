import {TestBed} from '@angular/core/testing';

import {PermissionService} from './permission-manager.services';

describe('PermissionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PermissionService = TestBed.get(PermissionService);
    expect(service).toBeTruthy();
  });
});
