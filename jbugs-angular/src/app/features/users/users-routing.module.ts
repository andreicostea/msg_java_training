import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { UsersComponent } from "./containers/users/users.component";
import {UserEditComponent} from "./containers/user-edit/user-edit.component";

const routes: Routes = [
  {
    path: '',
    component: UsersComponent
  },
  {
    path: 'edit',
    component: UserEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule {}
