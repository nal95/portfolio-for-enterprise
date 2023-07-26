import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SvgImageComputerComponent } from './svg-image-computer.component';

describe('SvgImageComputerComponent', () => {
  let component: SvgImageComputerComponent;
  let fixture: ComponentFixture<SvgImageComputerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SvgImageComputerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SvgImageComputerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
