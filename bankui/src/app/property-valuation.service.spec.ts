import { TestBed } from '@angular/core/testing';

import { PropertyValuationService } from './property-valuation.service';

describe('PropertyValuationService', () => {
  let service: PropertyValuationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PropertyValuationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
