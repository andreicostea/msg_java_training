import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/backend/backend.service";
import {Bug, BugJSON} from "../models/bugs.model";


@Injectable({
  providedIn: 'root'
})

export class BugsService {

  private bugsEndpoint = 'bugs';

  constructor(private backendService: BackendService) {
  }

  loadAllBugs(): Observable<Bug[]> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.bugsEndpoint}`);
  }
}
