import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ObservebuttonComponent } from './observebutton.component';

describe('ObservebuttonComponent', () => {
  let component: ObservebuttonComponent;
  let fixture: ComponentFixture<ObservebuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ObservebuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ObservebuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
