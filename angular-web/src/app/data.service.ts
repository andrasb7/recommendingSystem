import { Person } from './person/person';
import { Injectable } from '@angular/core';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';


@Injectable()
export class DataService {

  private currentIdBehavior = new BehaviorSubject<Person>(null);
  
  $currentId = this.currentIdBehavior.asObservable();
  public loggedInUSer: Person;
  constructor() { }
  
  changeUserId(user: Person) {
    this.currentIdBehavior.next(user);
    this.$currentId.
      subscribe(curr => {this.loggedInUSer = curr});
    
  }

}
