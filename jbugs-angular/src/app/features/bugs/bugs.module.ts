import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BugsComponent } from "./containers/bugs/bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";
import { BugsTableComponentComponent } from './components/bugs-table-component/bugs-table-component.component';
import { BugAddComponent } from './containers/bug-add/bug-add.component';
import {MatCardModule, MatListModule} from "@angular/material";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    BugsComponent,
    BugsTableComponentComponent,
    BugAddComponent,
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    BugsRoutingModule,
    MatCardModule,
    MatListModule,
    FormsModule
  ]
})
export class BugsModule { }
