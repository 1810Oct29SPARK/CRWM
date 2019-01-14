import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiabetesbuttonComponent } from './diabetesbutton.component';

describe('DiabetesbuttonComponent', () => {
  let component: DiabetesbuttonComponent;
  let fixture: ComponentFixture<DiabetesbuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiabetesbuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiabetesbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
