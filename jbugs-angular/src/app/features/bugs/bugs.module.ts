import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { CommonModule } from '@angular/common';
import { BugsComponent } from "./containers/bugs/bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";
import { BugsTableComponentComponent } from './components/bugs-table-component/bugs-table-component.component';

import {MatPaginatorModule, MatSort, MatSortModule, MatTableDataSource, MatTableModule} from "@angular/material";
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
import {BrowserModule} from "@angular/platform-browser";
import { BugEditComponent } from './containers/bug-edit/bug-edit.component';

@NgModule({
  declarations: [
    BugsComponent,
    BugsTableComponentComponent,
    BugAddComponent,
    BugDialogAddComponent,
    BugEditComponent,
  ],

  entryComponents:[BugsTableComponentComponent, BugEditComponent],

  imports: [
    HttpClientModule,
    MatTableModule,
    MatFormFieldModule,
    CommonModule,
    MatSortModule,
    BugsRoutingModule,
    MatCardModule,
    MatListModule,
    FormsModule,
    MatInputModule,
    MatDatepickerModule,
    MatButtonModule,
    ReactiveFormsModule,
    NativeDateModule,
    MatSelectModule,
    MatPaginatorModule


  ]
})
export class BugsModule { }
