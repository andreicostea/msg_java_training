import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from "./containers/users/users.component";
import { UsersRoutingModule } from "./users-routing.module";
import { UsersTableComponent } from './components/users-table/users-table.component';
import {
  MatButtonModule,
  MatDividerModule,
  MatInputModule,
  MatListModule,
  MatRadioModule,
  MatTableModule
} from "@angular/material";
import { UserEditComponent } from './containers/user-edit/user-edit.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    UsersComponent,
    UsersTableComponent,
    UserEditComponent
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
    FormsModule
  ]
})
export class UsersModule { }
