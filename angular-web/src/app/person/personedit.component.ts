import { DataService } from '../data.service';
import { Component, OnInit, OnDestroy } from '@angular/core';

import { Person } from './person';
import { PersonService } from './person.service';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-personedit',
  templateUrl: './personedit.component.html',
  styles: []
})
export class PersoneditComponent implements OnInit, OnDestroy {
  person: Person;
  sub: any;
  errorMessage: string = '';
  response: any;


  constructor(private personService: PersonService, private dataService: DataService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
      this.personService
        .get(this.dataService.loggedInUSer.id)
        .subscribe(p => this.person = p);
  }

  ngOnDestroy() {
  }

  savePersonDetails() {
    this.personService.save(this.person).subscribe(p => this.response = p,
                                                        e => this.errorMessage = e._body,
                                                        () => this.router.navigate(['mySeries/', this.person.id]));
  }
}
