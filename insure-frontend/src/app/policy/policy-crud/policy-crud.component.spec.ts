import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicyCrudComponent } from './policy-crud.component';

describe('PolicyCrudComponent', () => {
  let component: PolicyCrudComponent;
  let fixture: ComponentFixture<PolicyCrudComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PolicyCrudComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PolicyCrudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
