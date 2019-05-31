import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BugsComponent } from "./containers/bugs/bugs.component";

const routes: Routes = [
  {
    path: '',
    component: BugsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BugsRoutingModule {}
