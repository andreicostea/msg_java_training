import {Injectable} from '@angular/core';
import {Observable} from "rxjs";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/services/backend/backend.service";
import {Bug} from "../models/bugs.model";


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
    insertBug(bug : Bug) : Observable<any> {
    return  this.backendService
      .post(`jbugs/jbugs-api/bugs`, bug)

  }

}
