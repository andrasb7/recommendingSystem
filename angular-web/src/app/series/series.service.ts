import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Series } from './series';
import { UserSeries } from './userseries';
import 'rxjs/add/operator/map';

@Injectable()
export class SeriesService {
  private baseUrl = 'http://localhost:8080/rest-api/webapi/series';

  constructor(private http: Http) { }
  
    get(id: number): Observable<Series> {
    let series$ = this.http
      .get(`${this.baseUrl}/findById/${id}`, {headers: this.getHeaders()})
      .map(mapSeries);
      return series$;
  }
    getByUser(id: number): Observable<Series[]> {
    let series$ = this.http
      .get(`${this.baseUrl}/findAllByUserId/${id}`, {headers: this.getHeaders()})
      .map(mapMoreSeries);
      return series$;
  }
  
      getByName(name: string): Observable<Series[]> {
    let series$ = this.http
      .get(`${this.baseUrl}/findAllByName/${name}`, {headers: this.getHeaders()})
      .map(mapMoreSeries);
      return series$;
  }
  
    getAllTest(): Observable<Series[]> {
    let series$ = this.http
      .get(`${this.baseUrl}/findAllTest`, {headers: this.getHeaders()})
      .map(mapMoreSeries);
      return series$;
  }
  
    addToPerson(userSeries: UserSeries): Observable<UserSeries> {
    console.log('Add series to Person ' + JSON.stringify(userSeries));
    return this.http.post(`${this.baseUrl}/addSeriesToUser`, JSON.stringify(userSeries), {headers: this.getHeaders()}).map(mapUserSeries);
  }
    removeFromPerson(userSeries: UserSeries): Observable<UserSeries> {
    console.log('Remove series from Person ' + JSON.stringify(userSeries));
    return this.http.post(`${this.baseUrl}/removeSeriesFromUser`, 
      JSON.stringify(userSeries), {headers: this.getHeaders()}).map(mapUserSeries);
  }

    private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }

}

function mapMoreSeries(response: Response): Series[] {
  return response.json().map(toSeries);
}

function mapSeries(response: Response): Series {
  return toSeries(response.json());
}

function toSeries(r: any): Series {
  return r;
}

function mapUserSeries(response: Response): UserSeries {
  return toUserSeries(response.json());
}

function toUserSeries(r: any): UserSeries {
  return r;
}
