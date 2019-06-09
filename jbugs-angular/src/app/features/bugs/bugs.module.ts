import {NgModule} from '@angular/core';

import {HttpClientModule} from '@angular/common/http';

import {CommonModule} from '@angular/common';
import {BugsComponent} from "./containers/bugs/bugs.component";
import {BugsRoutingModule} from "./bugs-routing.module";
import {BugsTableComponentComponent} from './components/bugs-table-component/bugs-table-component.component';
import { ChartsModule } from 'ng2-charts';
import {
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatDatepickerModule,
  MatFormFieldModule,
  MatInputModule,
  MatListModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSortModule,
  MatTableModule,
  NativeDateModule
} from "@angular/material";
import {BugAddComponent} from './containers/bug-add/bug-add.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BugDialogAddComponent} from './components/bug-dialog-add/bug-dialog-add.component';
import {BugEditComponent} from './containers/bug-edit/bug-edit.component';
import {BugViewComponent} from "./containers/bug-view/bug-view.component";
import { BugsStatisticsComponent } from './components/bugs-statistics/bugs-statistics.component';

@NgModule({
  declarations: [
    BugsComponent,
    BugsTableComponentComponent,
    BugAddComponent,
    BugDialogAddComponent,
    BugEditComponent,
    BugViewComponent,
    BugsStatisticsComponent
  ],

  entryComponents: [BugsTableComponentComponent, BugEditComponent, BugViewComponent],

  imports: [
    ChartsModule,
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
    MatPaginatorModule,
    MatButtonToggleModule
  ]
})
export class BugsModule {
}
