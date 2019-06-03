import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { BugsComponent } from "./containers/bugs/bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";
import { BugsTableComponentComponent } from './components/bugs-table-component/bugs-table-component.component';

import {MatSort, MatSortModule, MatTableDataSource, MatTableModule} from "@angular/material";
import {MatFormFieldModule} from "@angular/material";
import { BugAddComponent } from './containers/bug-add/bug-add.component';
import {
  MatButtonModule,
  MatCardModule,
  MatDatepickerModule,
  MatInputModule,
  MatListModule, MatSelectModule,
  NativeDateModule
} from "@angular/material";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { BugDialogAddComponent } from './components/bug-dialog-add/bug-dialog-add.component';

@NgModule({
  declarations: [
    BugsComponent,
    BugsTableComponentComponent
  ],
  imports: [
    CommonModule,
    BugsRoutingModule,
    MatTableModule,
    MatSortModule,
    MatFormFieldModule
    BugsTableComponentComponent,
    BugAddComponent,
    BugDialogAddComponent,
 ],
  imports: [
    HttpClientModule,
    CommonModule,
    BugsRoutingModule,
    MatCardModule,
    MatListModule,
    FormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatButtonModule,
    ReactiveFormsModule,
    NativeDateModule,
    MatSelectModule
  ]
})
export class BugsModule { }
