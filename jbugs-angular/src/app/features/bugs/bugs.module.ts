import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BugsComponent } from "./bugs.component";
import { BugsRoutingModule } from "./bugs-routing.module";

@NgModule({
  declarations: [BugsComponent],
  imports: [
    CommonModule,
    BugsRoutingModule
  ]
})
export class NotificationsModule { }
