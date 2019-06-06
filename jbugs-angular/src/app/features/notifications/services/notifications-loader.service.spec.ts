import {TestBed} from '@angular/core/testing';

import {NotificationsLoaderService} from './notifications-loader.service';

describe('NotificationsLoaderService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NotificationsLoaderService = TestBed.get(NotificationsLoaderService);
    expect(service).toBeTruthy();
  });
});
