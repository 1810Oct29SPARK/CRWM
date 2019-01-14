import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MalariabuttonComponent } from './malariabutton.component';

describe('MalariabuttonComponent', () => {
  let component: MalariabuttonComponent;
  let fixture: ComponentFixture<MalariabuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MalariabuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MalariabuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
