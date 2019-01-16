import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiagnosebuttonComponent } from './diagnosebutton.component';

describe('DiagnosebuttonComponent', () => {
  let component: DiagnosebuttonComponent;
  let fixture: ComponentFixture<DiagnosebuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiagnosebuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiagnosebuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
