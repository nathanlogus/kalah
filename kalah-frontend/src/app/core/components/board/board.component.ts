import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.scss']
})
export class BoardComponent implements OnChanges {
  @Input() gameStatus: any;

  constructor() { }


  ngOnChanges(changes: SimpleChanges): void {
    this.gameStatus = changes.gameStatus.currentValue;
    console.log(changes);
  }

  selectPit(pitId: Number) {
    console.log(pitId);
  }



}
