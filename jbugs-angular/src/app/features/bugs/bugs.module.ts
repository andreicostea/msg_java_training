import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BugsComponent } from "./containers/bugs/bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";
import { BugsTableComponentComponent } from './components/bugs-table-component/bugs-table-component.component';
import {MatSort, MatSortModule, MatTableDataSource, MatTableModule} from "@angular/material";
import {MatFormFieldModule} from "@angular/material";

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
  ]
})
export class BugsModule { }
