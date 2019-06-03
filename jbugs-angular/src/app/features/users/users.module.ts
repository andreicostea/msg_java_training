import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsersComponent} from "./containers/users/users.component";
import {UsersRoutingModule} from "./users-routing.module";
import {UsersTableComponent} from './components/users-table/users-table.component';
import {
  MatButtonModule,
  MatCheckboxModule,
  MatDialogModule,
  MatDividerModule,
  MatInputModule,
  MatListModule,
  MatRadioModule,
  MatTableModule
} from "@angular/material";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UsersUpdateDialogComponent} from './components/users-update-dialog/users-update-dialog.component';

@NgModule({
  declarations: [
    UsersComponent,
    UsersTableComponent,
    UsersUpdateDialogComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    MatTableModule,
    MatRadioModule,
    MatButtonModule,
    MatInputModule,
    MatDividerModule,
    MatListModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatDialogModule
  ],
  entryComponents: [UsersUpdateDialogComponent]
})
export class UsersModule {
}
