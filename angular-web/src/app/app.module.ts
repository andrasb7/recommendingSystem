import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routes';


import { AppComponent } from './app.component';
import { DataService } from './data.service';
import { PersonService } from './person/person.service';
import { PersoneditComponent } from './person/personedit.component';
import { SeriesService } from './series/series.service';
import { SerieslistComponent } from './series/serieslist.component';
import { SeriesdetailsComponent } from './series/seriesdetails.component';
import { PersonregisterComponent } from './person/personregister.component';
import { PersonloginComponent } from './person/personlogin.component';


@NgModule({
  declarations: [
    AppComponent,
    SerieslistComponent,
    SeriesdetailsComponent,
    PersonregisterComponent,
    PersonloginComponent,
    PersoneditComponent
  ],
  imports: [
    BrowserModule,
     FormsModule,
    HttpModule,
    routing
  ],
  
  bootstrap: [AppComponent]
})
export class AppModule { }
