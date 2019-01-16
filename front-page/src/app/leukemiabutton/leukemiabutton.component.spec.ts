import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeukemiabuttonComponent } from './leukemiabutton.component';

describe('LeukemiabuttonComponent', () => {
  let component: LeukemiabuttonComponent;
  let fixture: ComponentFixture<LeukemiabuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeukemiabuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeukemiabuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
