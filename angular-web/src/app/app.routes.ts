import { Routes, RouterModule }  from '@angular/router';
import { SerieslistComponent } from './series/serieslist.component';
import { SeriesdetailsComponent } from './series/seriesdetails.component';
import { PersonregisterComponent } from './person/personregister.component';
import { PersonloginComponent } from './person/personlogin.component';
import { PersoneditComponent } from './person/personedit.component';


// Route config let's you map routes to components
const routes: Routes = [
  // map '/persons' to the people list component
  {
    path: 'seriesList',
    component: SerieslistComponent
  },
  // map '/persons/:id' to person details component
  {
    path: 'series/:id',
    component: SeriesdetailsComponent
  },


  // map '/' to '/persons' as our default route
  {
    path: '',
    redirectTo: '/personAuth',
    pathMatch: 'full'
  },
  
    {
    path: 'personRegister',
    component: PersonregisterComponent
  },
    {
    path: 'personAuth',
    component: PersonloginComponent
  },
        {
    path: 'personEdit/:id',
    component: PersoneditComponent
  },
        {
    path: 'mySeries/:id',
    component: SerieslistComponent
  },
  
  
];

export const routing = RouterModule.forRoot(routes);
