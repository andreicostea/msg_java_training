import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PermissionRoutingModule} from "./permission-manager-routing.module";
import {PermissionManagerInsertButtonComponent} from "./components/permission-manager-firstpage/permission-manager-firstpage.component";
import {MatButtonToggleModule, MatFormFieldModule, MatSelectModule} from "@angular/material";
import {InsertComponent} from "./containers/addpermission/insert.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {PermissionManagerInsertComponent} from './containers/permission-manager/permission-manager.component';
import {
  MatButtonModule,
  MatCardModule,
  MatInputModule,
  MatListModule,
  MatOptionModule,
  MatCheckboxModule,
  MatDialogModule,
  MatDividerModule,
  MatRadioModule,
  MatTableModule
} from "@angular/material";
@NgModule({
  declarations: [
    PermissionManagerInsertComponent,
    PermissionManagerInsertButtonComponent,
    InsertComponent,
  ],
  entryComponents: [
    InsertComponent
  ],
  imports: [
    CommonModule,
    PermissionRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonToggleModule,
    MatDialogModule,
    MatCheckboxModule,
    MatListModule,
    MatDividerModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatOptionModule,
    MatRadioModule

  ]
})
export class PermissionManagerModule {
}
