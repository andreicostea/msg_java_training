import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {NotificationsRoutingModule} from "./notifications-routing.module";
import {NotificationsViewComponent} from "./components/notifications-view/notifications-view.component";
import {NotificationsComponent} from "./containers/notifications/notifications.component";
import {MatExpansionModule, MatFormFieldModule, MatTableModule} from "@angular/material";

@NgModule({
  declarations: [NotificationsComponent,NotificationsViewComponent],
  imports: [
    CommonModule,
    NotificationsRoutingModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatTableModule
  ]
})
export class NotificationsModule {
}
