import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {map, tap} from "rxjs/operators";

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

  // get(id: number): Observable<User> {
  //   return this.backendService
  //     .get(`${environment.baseUrl}/${this.usersEndpoint}/${id}`)
  //     .pipe(map((result: UserJSON) => User.fromJSON(result)));
  //
  // }

}
