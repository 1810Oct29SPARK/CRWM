import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ThankyoubuttonComponent } from './thankyoubutton.component';

describe('ThankyoubuttonComponent', () => {
  let component: ThankyoubuttonComponent;
  let fixture: ComponentFixture<ThankyoubuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ThankyoubuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ThankyoubuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
