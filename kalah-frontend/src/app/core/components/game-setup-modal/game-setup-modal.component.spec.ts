import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GameSetupModalComponent } from './game-setup-modal.component';

describe('GameSetupModalComponent', () => {
  let component: GameSetupModalComponent;
  let fixture: ComponentFixture<GameSetupModalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GameSetupModalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GameSetupModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
