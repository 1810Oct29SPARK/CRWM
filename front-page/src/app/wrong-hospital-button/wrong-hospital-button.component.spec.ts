import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WrongHospitalButtonComponent } from './wrong-hospital-button.component';

describe('WrongHospitalButtonComponent', () => {
  let component: WrongHospitalButtonComponent;
  let fixture: ComponentFixture<WrongHospitalButtonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WrongHospitalButtonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WrongHospitalButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
