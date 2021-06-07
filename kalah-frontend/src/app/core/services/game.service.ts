import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  constructor(private http: HttpClient) { }

  createNewGame(quantityOfSeeds: Number): Observable<any> {
    let params = new HttpParams().set('numberOfSeeds', quantityOfSeeds.toString());
    let body = {};
    return this.http.post(environment.gameApiUrl, body, { params: params });
  }

  getGameStatus(id: Number): Observable<any> {
    return this.http.get(environment.gameApiUrl + "/" + id.toString());
  }

  sow(gameId: Number, pitId: Number): Observable<any> {
    let body = {};
    return this.http.post(environment.gameApiUrl + "/" + gameId.toString() + "/pits/" + pitId.toString(), body);
  }

}
