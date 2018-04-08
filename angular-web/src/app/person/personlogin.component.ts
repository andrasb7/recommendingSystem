import {DataService} from '../data.service';
import {Component, OnInit, Output, EventEmitter} from '@angular/core';

import {Person} from './person';
import {PersonService} from './person.service';
import {Router} from '@angular/router';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-personlogin',
  templateUrl: './personlogin.component.html',
  styles: [],
  providers: [PersonService],

})
export class PersonloginComponent implements OnInit {
  public person: Person;
  sub: any;
  response: any;
  username: string;
  password: string;
  id: number;

  constructor(private personService: PersonService, private dataService: DataService, private router: Router) {}

  ngOnInit() {
  }

  authenticateUser() {
    this.personService.getByUserName(this.username, this.password)
      .subscribe(p => this.doAuth(p)
      );
  }

  doAuth(p) {
    this.person = p;
    this.dataService.changeUserId(this.person);
    this.router.navigate(['\mySeries', this.person.id]);
  }



}
