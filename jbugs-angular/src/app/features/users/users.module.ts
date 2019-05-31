import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from "./containers/users/users.component";
import { UsersRoutingModule } from "./users-routing.module";
import { UsersLocallyUsedTestComponentComponent } from './components/users-locally-used-test-component/users-locally-used-test-component.component';
import { UsersInsertButtonComponent } from './components/users-insert-button/users-insert-button.component';
import { UsersInsertComponent } from './containers/users-insert/users-insert.component';
import {FormsModule} from "@angular/forms";
import {
  MatButtonModule,
  MatCardModule,
  MatFormFieldModule,
  MatListModule,
  MatOptionModule,
  MatSelectModule
} from "@angular/material";

@NgModule({
  declarations: [
    UsersComponent,
    UsersLocallyUsedTestComponentComponent,
    UsersInsertButtonComponent,
    UsersInsertComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule,
    MatOptionModule,
    MatFormFieldModule,
    MatSelectModule,
    MatCardModule,
    MatListModule,
    MatButtonModule
  ]
})
export class UsersModule { }
