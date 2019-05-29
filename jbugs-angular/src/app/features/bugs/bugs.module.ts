import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { BugsComponent } from "./containers/bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";
import { BugsTableComponentComponent } from './components/bugs-table-component/bugs-table-component.component';

@NgModule({
  declarations: [
    BugsComponent,
    BugsTableComponentComponent,
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    BugsRoutingModule
  ]
})
export class BugsModule { }
