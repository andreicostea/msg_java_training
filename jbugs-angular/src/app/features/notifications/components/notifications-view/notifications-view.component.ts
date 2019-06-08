import {Component, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger} from "@angular/animations";
import {NotificationsLoaderService} from "../../services/notifications-loader.service";
import {Notifications} from "../../models/notifications.model";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";


export interface PeriodicElement {

  date: number;
  type: string;
  description: string;
}


@Component({
  selector: 'app-notifications-view',
  templateUrl: './notifications-view.component.html',
  styleUrls: ['./notifications-view.component.css',
  ], animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]

})
export class NotificationsViewComponent implements OnInit {
  columnsToDisplay = ['notificationType', 'date'];
  expandedElement: PeriodicElement | null;
  notifications: Notifications[];

  constructor(private notificationsService: NotificationsLoaderService, private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.cleanNotifications();
    this.getNotificationsForCurrentUser();

  }

  cleanNotifications() {
    this.notificationsService.deleteNotifications().subscribe();
  }

  getNotificationsForCurrentUser() {
    var that = this;
    this.notificationsService.getNotificationsForUser(this.authenticationService.getUserId())
      .subscribe(
        function (result) {
          that.notifications = result;
          console.log(that.notifications);
        },
        error => {
          console.log(error)

        }
      );
  }
}
