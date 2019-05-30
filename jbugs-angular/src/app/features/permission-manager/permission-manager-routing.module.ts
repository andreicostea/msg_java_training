import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PermissionManagerInsertComponent} from "./containers/permission-manager.containers.component/permission-manager.containers.component";
import {InsertorremovepermissionComponent} from "./containers/addorremovepermission/insertorremovepermission.component";

const routes: Routes = [
  {
    path: '',
    component: PermissionManagerInsertComponent
  },
  {
    path: 'insert',
    component: PermissionManagerInsertComponent
  },
  {
    path: 'insertorremovepermission',
    component: InsertorremovepermissionComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PermissionRoutingModule {
}
