import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsersComponent} from "./containers/users/users.component";
import {UsersRoutingModule} from "./users-routing.module";
import {UsersInsertButtonComponent} from './components/users-insert-button/users-insert-button.component';
import {UsersInsertComponent} from './containers/users-insert/users-insert.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UsersUpdateDialogComponent} from './components/users-update-dialog/users-update-dialog.component';

import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDialogModule,
  MatDividerModule,
  MatFormFieldModule, MatIconModule,
  MatInputModule,
  MatListModule,
  MatOptionModule,
  MatRadioModule,
  MatSelectModule, MatSnackBarModule,
  MatTableModule
} from "@angular/material";
import {UsersTableComponent} from "./components/users-table/users-table.component";

@NgModule({
  declarations: [
    UsersComponent,
    UsersInsertButtonComponent,
    UsersInsertComponent,
    UsersTableComponent,
    UsersUpdateDialogComponent
  ],
  entryComponents: [
    UsersInsertComponent, UsersUpdateDialogComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule,
    MatOptionModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule,
    MatTableModule,
    MatRadioModule,
    MatButtonModule,
    MatInputModule,
    MatDividerModule,
    MatListModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatDialogModule,
    MatIconModule,
    MatSnackBarModule
  ],

})
export class UsersModule {
}
