import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BugsComponent } from "./containers/bugs/bugs.component";
import {BugAddComponent} from "./containers/bug-add/bug-add.component";

const routes: Routes = [
  {
    path: '',
    component: BugsComponent
  },
  {
    path: 'insert',
    component: BugAddComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BugsRoutingModule {}
