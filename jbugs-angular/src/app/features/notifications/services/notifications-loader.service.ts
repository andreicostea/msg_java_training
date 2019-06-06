import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Bug} from "../../bugs/models/bugs.model";
import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/services/backend/backend.service";
import {Notifications} from "../models/notifications.model";

@Injectable({
  providedIn: 'root'
})
export class NotificationsLoaderService {
  private notificationsEndpoint = 'notifications';
  constructor(private backendService:BackendService) {
  }

  public getNotificationsForUser(userId: number): Observable<Notifications[]> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.notificationsEndpoint}/${userId}`);
  }
}
