import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ViewProfileComponent} from "./components/view-profile/view-profile.component";

const routes: Routes = [
  {
    path: "",
    component: ViewProfileComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ViewProfileRoutingModule { }
