import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PermissionRoutingModule} from "./permission-manager-routing.module";
import {PermissionManagerInsertButtonComponent} from "./components/permission-manager-test-component/permission-manager-test-component.component";
import {MatButtonToggleModule, MatFormFieldModule, MatSelectModule} from "@angular/material";
import {InsertComponent} from "./containers/addpermission/insert.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PermissionManagerInsertComponent} from './containers/permission-manager.containers.component/permission-manager.containers.component';

@NgModule({
  declarations: [
    PermissionManagerInsertComponent,
    PermissionManagerInsertButtonComponent,
    InsertComponent,

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