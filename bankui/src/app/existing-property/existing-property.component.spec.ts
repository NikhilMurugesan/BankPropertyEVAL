import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExistingPropertyComponent } from './existing-property.component';

describe('ExistingPropertyComponent', () => {
  let component: ExistingPropertyComponent;
  let fixture: ComponentFixture<ExistingPropertyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ExistingPropertyComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ExistingPropertyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
