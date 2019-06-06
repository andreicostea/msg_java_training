import {Injectable} from '@angular/core';
import {Observable} from "rxjs";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/backend/backend.service";
import {Bug, BugJSON} from "../models/bugs.model";
import {User, UserJSON} from "../../users/models/users.model";


@Injectable({
  providedIn: 'root'
})

export class BugsService {

  private bugsEndpoint = 'bugs';

  constructor(private backendService: BackendService) {
  }

  loadAllBugs(): Observable<any> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.bugsEndpoint}`);
  }
    insertBug(bug : Bug) : Observable<any> {
    return  this.backendService
      .post(`jbugs/jbugs-api/bugs`, bug)

  }

  editBug(bug: Bug) : Observable<any>{
    return this.backendService
      .put(`jbugs/jbugs-api/bugs`, bug);
  }

  getStatusComplete(status: string): Observable<any> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.bugsEndpoint}/status-all/${status}`);

  }

  getStatusLimited(status: string): Observable<any> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.bugsEndpoint}/status-limited/${status}`);

  }

}
