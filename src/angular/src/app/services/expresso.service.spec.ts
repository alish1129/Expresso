import { TestBed, inject } from '@angular/core/testing';

import { ExpressoService } from './expresso.service';

describe('ExpressoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExpressoService]
    });
  });

  it('should be created', inject([ExpressoService], (service: ExpressoService) => {
    expect(service).toBeTruthy();
  }));
});
