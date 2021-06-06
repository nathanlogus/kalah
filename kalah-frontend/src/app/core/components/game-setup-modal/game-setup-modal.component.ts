import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-game-setup-modal',
  templateUrl: './game-setup-modal.component.html',
  styleUrls: ['./game-setup-modal.component.scss'],
  providers: [GameService]
})
export class GameSetupModalComponent implements OnInit {
  value = 4;
  constructor(private gameService: GameService, public dialogRef: MatDialogRef<GameSetupModalComponent>) { }

  ngOnInit(): void {
  }

  changeValue(value: any){
    this.value = value.value;
  }

  createNewGame(){
    this.gameService.createNewGame(this.value).subscribe((game: any) => {
      this.closeDialog(game);
    });
  }

  closeDialog(game: any) {
    this.dialogRef.close(game);
  }

}
