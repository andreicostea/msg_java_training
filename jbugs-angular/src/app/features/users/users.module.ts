import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from "./containers/users.component";
import { UsersRoutingModule } from "./users-routing.module";
import { UsersTableComponent } from './components/users-table/users-table.component';
import {MatButtonModule, MatRadioModule, MatTableModule} from "@angular/material";

@NgModule({
  declarations: [
    UsersComponent,
    UsersTableComponent
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    MatTableModule,
    MatRadioModule,
    MatButtonModule
  ]
})
export class UsersModule { }
