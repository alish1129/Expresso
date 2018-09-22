import { TestBed, inject } from '@angular/core/testing';

import { ExpressoServiceProviderService } from './expresso-service-provider.service';

describe('ExpressoServiceProviderService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ExpressoServiceProviderService]
    });
  });

  it('should be created', inject([ExpressoServiceProviderService], (service: ExpressoServiceProviderService) => {
    expect(service).toBeTruthy();
  }));
});
