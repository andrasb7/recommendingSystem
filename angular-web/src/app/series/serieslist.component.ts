import {DataService} from '../data.service';
import {Component, OnInit, OnDestroy} from '@angular/core';
import {SeriesService} from './series.service';
import {Series} from './series';
import {PersonService} from '../person/person.service';
import {Person} from '../person/person';
import {UserSeries} from './userseries';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-serieslist',
  templateUrl: './serieslist.component.html',
  styles: [],
  providers: [PersonService],
})
export class SerieslistComponent implements OnInit, OnDestroy {

  seriesList: Series[] = [];
  mySeriesList: Series[] = [];
  searchField: string;
  currentUserId: number;
  sub: any;
  userSeries: UserSeries;
  search: boolean;

  constructor(public seriesService: SeriesService, private dataService: DataService, private router: Router) {}

  ngOnInit() {
    this.search = false;
    this.searchField = '';
    console.log(this.dataService.loggedInUSer);
    this.currentUserId = this.dataService.loggedInUSer.id;
    this.seriesService.getByUser(this.currentUserId).subscribe(s => this.mySeriesList = s);

  }

  ngOnDestroy(): void {
  }

  searchByName() {
    this.search = true;
    console.log(this.searchField);
    this.seriesService.getByName(this.searchField).subscribe(s => this.seriesList = s);
  }


addToFavorite(seriesId) {
  this.userSeries = new UserSeries(seriesId, this.dataService.loggedInUSer.id);
  this.seriesService.addToPerson(this.userSeries).subscribe();
}

removeFromFavorites(seriesId) {
  this.userSeries = new UserSeries(seriesId, this.dataService.loggedInUSer.id);

  this.seriesService.removeFromPerson(this.userSeries).subscribe();

  for (let i = 0; i < this.mySeriesList.length; ++i) {
    if (this.mySeriesList[i].id === seriesId) {
      this.mySeriesList.splice(i, 1);
    }

  }
}
  
  
  
}
