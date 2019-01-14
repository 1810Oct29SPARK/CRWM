import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MotorneuronbuttonComponent } from './motorneuronbutton.component';

describe('MotorneuronbuttonComponent', () => {
  let component: MotorneuronbuttonComponent;
  let fixture: ComponentFixture<MotorneuronbuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MotorneuronbuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MotorneuronbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
