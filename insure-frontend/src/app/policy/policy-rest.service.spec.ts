import { TestBed } from '@angular/core/testing';

import { PolicyRestService } from './policy-rest.service';

describe('PolicyRestService', () => {
  let service: PolicyRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PolicyRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
