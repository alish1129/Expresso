import { TestBed, inject } from '@angular/core/testing';

import { SorterService } from './sorter.service';

describe('SorterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SorterService]
    });
  });

  it('should be created', inject([SorterService], (service: SorterService) => {
    expect(service).toBeTruthy();
  }));
});
