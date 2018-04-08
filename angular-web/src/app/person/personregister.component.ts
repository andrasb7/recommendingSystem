import { DataService } from '../data.service';
import { Component, OnInit, OnDestroy } from '@angular/core';

import { Person } from './person';
import { PersonService } from './person.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personregister',
  templateUrl: './personregister.component.html',
  styles: [],
  providers: [PersonService],
 
})
export class PersonregisterComponent implements OnInit {

  person: Person;
  sub: any;
  response: any;
  name: string;
  surName: string;
  username: string;
  gender: string;
  birthyear: number;
  nation: string;
  password: string;

  constructor(private personService: PersonService, private dataService: DataService, private router: Router) { }

  ngOnInit() {
  }
  registerUser() {
    this.person = new Person();
    this.person.name = this.name;
    this.person.surName = this.surName;
    this.person.userName = this.username;
    this.person.birthYear = this.birthyear;
    this.person.nation = this.nation;
    this.person.gender = this.gender;
    this.person.password = this.password;
    this.personService.register(this.person).
      subscribe(p => this.doRegister(p));
  }
  
    doRegister(p) {
    this.person = p;
    this.router.navigate(['\personAuth']);
  }
  


}
