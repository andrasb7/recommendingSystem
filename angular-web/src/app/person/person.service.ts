import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { Person } from './person';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/finally';

@Injectable()
export class PersonService {
  private baseUrl: string = 'http://localhost:8080/rest-api/webapi/user';

  constructor(private http: Http) {
   
  }
  

  get(id: number): Observable<Person> {
    let person$ = this.http
      .get(`${this.baseUrl}/findById/${id}`, {headers: this.getHeaders()})
      .map(mapPerson);
      return person$;
  }
  
    getByUserName(userName: string, password: string): Observable<Person> {
    let person$ = this.http
      .get(`${this.baseUrl}/findByUserName/${userName}/${password}`, {headers: this.getHeaders()})
      .map(mapPerson);
     
      
      return person$;
  }
  
  save(person: Person): Observable<Person> {
    console.log('Saving person ' + JSON.stringify(person));
    return this.http.put(`${this.baseUrl}/update`, JSON.stringify(person), {headers: this.getHeaders()}).map(mapPerson);
  }


  register(person: Person): Observable<Person> {
    console.log('Register person ' + JSON.stringify(person));
    return this.http.post(`${this.baseUrl}/register`, JSON.stringify(person), {headers: this.getHeaders()}).map(mapPerson);
  }
  

  private getHeaders() {
    let headers = new Headers();
    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');
    return headers;
  }
}

function mapPersons(response: Response): Person[] {
  return response.json().map(toPerson);
}

function mapPerson(response: Response): Person {
  return toPerson(response.json());
}

function toPerson(r: any): Person {
  return r;
}
