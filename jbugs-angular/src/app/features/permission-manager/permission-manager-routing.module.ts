import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PermissionManagerInsertComponent} from "./containers/permission-manager.containers.component/permission-manager.containers.component";
import {InsertComponent} from "./containers/addpermission/insert.component";

const routes: Routes = [
  {
    path: '',
    component: PermissionManagerInsertComponent
  },
  {
    path: 'insert',
    component: InsertComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PermissionRoutingModule {
}
