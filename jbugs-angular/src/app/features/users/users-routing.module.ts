import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from "./containers/users/users.component";
import {UsersInsertComponent} from "./containers/users-insert/users-insert.component";

const routes: Routes = [
  {
    path: '',
    component: UsersComponent
  },
  {
    path: 'insert',
    component: UsersInsertComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule {}
