import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LaryngitisbuttonComponent } from './laryngitisbutton.component';

describe('LaryngitisbuttonComponent', () => {
  let component: LaryngitisbuttonComponent;
  let fixture: ComponentFixture<LaryngitisbuttonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LaryngitisbuttonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LaryngitisbuttonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
