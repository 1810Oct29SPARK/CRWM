import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FibromyalgiabuttonComponent } from './fibromyalgiabutton.component';

describe('FibromyalgiabuttonComponent', () => {
  let component: FibromyalgiabuttonComponent;
  let fixture: ComponentFixture<FibromyalgiabuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FibromyalgiabuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FibromyalgiabuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
