import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { GameSetupModalComponent } from './core/components/game-setup-modal/game-setup-modal.component';
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

  constructor(public dialog: MatDialog, private gameService: GameService) { }

  ngOnInit(): void {
    this.openDialog();
  }

  openDialog() {
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
}
