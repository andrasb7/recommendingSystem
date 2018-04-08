import { DataService } from '../data.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Series } from './series';
import { SeriesService } from './series.service';
import { UserSeries } from './userseries';

@Component({
  selector: 'app-seriesdetails',
  templateUrl: './seriesdetails.component.html',
  styles: [],

})
export class SeriesdetailsComponent implements OnInit, OnDestroy {
  userSeries: UserSeries;
  series: Series;
  sub: any;
  id: number;
  constructor(private seriesService: SeriesService,
    private route: ActivatedRoute,
    private router: Router, private dataService: DataService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      let id = Number.parseInt(params['id']);
      this.seriesService
        .get(id)
        .subscribe(p => this.series = p);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  addToFavorite(seriesId) {
    this.userSeries = new UserSeries(seriesId, this.dataService.loggedInUSer.id);
    this.seriesService.addToPerson(this.userSeries).subscribe();
  }
  
    removeFromFavorites(seriesId) {
    this.userSeries = new UserSeries(seriesId, this.dataService.loggedInUSer.id);
    this.seriesService.removeFromPerson(this.userSeries).subscribe();
  }
  
  backToSeriesList() {
    this.router.navigate(['\mySeries', this.dataService.loggedInUSer.id]);
  }
}
