import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailStockInfoComponent } from './detail-stock-info.component';

describe('DetailStockInfoComponent', () => {
  let component: DetailStockInfoComponent;
  let fixture: ComponentFixture<DetailStockInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailStockInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailStockInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
