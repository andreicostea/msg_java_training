import { TestBed } from '@angular/core/testing';

import { LoginGuardService } from './login-guard.service';

describe('LoginGuardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginGuardService = TestBed.get(LoginGuardService);
    expect(service).toBeTruthy();
  });
});
