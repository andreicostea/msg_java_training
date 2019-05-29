import { NgModule } from '@angular/core';
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
    CommonModule,
    BugsRoutingModule
  ]
})
export class BugsModule { }
