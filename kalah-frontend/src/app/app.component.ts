import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { GameSetupModalComponent } from './core/components/game-setup-modal/game-setup-modal.component';
import { WinnerModalComponent } from './core/components/winner-modal/winner-modal.component';
import { GameService } from './core/services/game.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [GameService]
})
export class AppComponent implements OnInit {
  gameData: any;
  gameStatus: any;
  currentPlayer: any = "Select one pit to start game.";

  constructor(public dialog: MatDialog, private gameService: GameService) { }

  ngOnInit(): void {
    this.newGameDialog();
  }

  newGameDialog() {
    const dialogRef = this.dialog.open(GameSetupModalComponent, { disableClose: true });
    dialogRef.afterClosed().subscribe(gameData => {
      this.gameData = gameData;
      this.gameService.getGameStatus(gameData.id).subscribe(status => {
        this.gameStatus = status;
      });
    });
  }

  checkPlayer(){
    if(this.gameStatus.playerTurn != undefined)
      return this.gameStatus.playerTurn;
    else
      return "Select one pit to start game.";
  }

  updatePlayer(currentPlayer: any){
    if(currentPlayer == "PLAYER_NORTH"){
      this.currentPlayer = "Player North";
    } else if (currentPlayer == "PLAYER_SOUTH"){
      this.currentPlayer = "Player South";
    } else {
      this.currentPlayer = "Select one pit to start game.";
    }
  }

  openWinnerDialog(winner: any){
    const dialogRef = this.dialog.open(WinnerModalComponent, { disableClose: true, data :{'winner': winner} });
  }
}
