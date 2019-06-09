import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {BugsComponent} from "./containers/bugs/bugs.component";

import {BugAddComponent} from "./containers/bug-add/bug-add.component";
import {BugsStatisticsComponent} from "./components/bugs-statistics/bugs-statistics.component";

const routes: Routes = [
  {
    path: '',
    component: BugsComponent

  },
  {
    path: 'insert',
    component: BugAddComponent
  }, {
    path: 'statistics',
    component: BugsStatisticsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BugsRoutingModule {
}
