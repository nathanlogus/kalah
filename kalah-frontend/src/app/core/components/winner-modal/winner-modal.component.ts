import { Component, Inject, OnInit } from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-winner-modal',
  templateUrl: './winner-modal.component.html',
  styleUrls: ['./winner-modal.component.scss']
})
export class WinnerModalComponent implements OnInit {
  winner: string = "";

  constructor( @Inject(MAT_DIALOG_DATA) public data: any) {
    console.log(data);
    if(data.winner == "PLAYER_SOUTH"){
      this.winner = "Player South!";
    } else {
      this.winner = "Player North!";
    }
  }

  ngOnInit(): void {
  }

  resetGame() {
    location.reload();
  }

}
