import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PermissionRoutingModule} from "./permission-manager-routing.module";
import {PermissionManagerInsertComponent} from './containers/permission-manager.containers.component/permission-manager.containers.component';
import {PermissionManagerInsertButtonComponent} from "./components/permission-manager-test-component/permission-manager-test-component.component";
import {MatButtonToggleModule, MatFormFieldModule, MatSelectModule} from "@angular/material";
import {InsertorremovepermissionComponent} from "./containers/addorremovepermission/insertorremovepermission.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    PermissionManagerInsertComponent,
    PermissionManagerInsertButtonComponent,
    InsertorremovepermissionComponent
  ],
  imports: [
    CommonModule,
    PermissionRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonToggleModule
  ]
})
export class PermissionManagerModule {
}
