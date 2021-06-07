import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { GameService } from '../../services/game.service';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss'],
  providers: [GameService]
})
export class BoardComponent implements OnChanges {
  @Input() gameStatus: any;
  @Output() currentPlayer = new EventEmitter<string>();
  @Output() winner = new EventEmitter<string>();

  constructor(private gameService: GameService) { }


  ngOnChanges(changes: SimpleChanges): void {
    this.gameStatus = changes.gameStatus.currentValue;
  }

  selectPit(pitId: Number) {
    this.gameService.sow(this.gameStatus.id, pitId).subscribe(gameData => {
      this.gameStatus = gameData;
      this.currentPlayer.emit(gameData.playerTurn);
      this.validateWinner(gameData);
    });
  }

  validateWinner(gameData: any) {
    let sumOfPits = 0;
    gameData.pits.forEach((pit: any) => {
      if(pit.pitIdentifier != "7" && pit.pitIdentifier != "14"){
        sumOfPits = sumOfPits + pit.quantityOfSeeds;
      }
    });

    if (sumOfPits == 0) {
      if (gameData.pits[6].quantityOfSeeds > gameData.pits[13].quantityOfSeeds) {
        this.winner.emit("PLAYER_SOUTH");
      } else {
        this.winner.emit("PLAYER_NORTH");
      }
    }
  }
}
