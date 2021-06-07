import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { BoardComponent } from './components/board/board.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MatDialogModule } from '@angular/material/dialog';
import { GameSetupModalComponent } from './components/game-setup-modal/game-setup-modal.component';
import { MatSliderModule } from '@angular/material/slider';
import { MatButtonModule } from '@angular/material/button';
import { WinnerModalComponent } from './components/winner-modal/winner-modal.component';




@NgModule({
  declarations: [
    BoardComponent,
    GameSetupModalComponent,
    WinnerModalComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    HttpClientModule,
    FlexLayoutModule,
    MatDialogModule,
    MatSliderModule,
    MatButtonModule,
  ],
  exports: [
    HttpClientModule,
    BoardComponent,
    MatDialogModule,
    MatSliderModule,
    MatButtonModule,
  ]
})
export class CoreModule { }
