import { DataService } from './data.service';
import { Component } from '@angular/core';
import { SeriesService } from './series/series.service';
import { Series } from './series/series';
import { PersonService } from './person/person.service';
import { Person } from './person/person';
import { SerieslistComponent } from './series/serieslist.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [SeriesService, PersonService, DataService],
})
export class AppComponent {
  title = 'app';
  sub: any;
  public person: Person;
  seriesList: Series[] =[];
  searchField: string;
  currentUserId: number;

  constructor(private seriesService: SeriesService, private personService: PersonService, private dataService: DataService) {
    this.dataService.$currentId.subscribe(id => this.person = id);
   }
  
    ngOnInit() {
    }
  
}
