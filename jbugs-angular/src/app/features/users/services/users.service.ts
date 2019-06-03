import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/backend/backend.service";
import {User} from "../models/users.model";
import {AuthenticationService} from "../../../core/services/authentication.service";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private usersEndpoint = 'users';

  constructor(private backendService: BackendService,
              private authenticationService: AuthenticationService) {
  }

  loadUserByUsername(username: string): Observable<User> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.usersEndpoint}/${username}`)
      .pipe(map((result: User) => {
        const currentUser = User.fromJSON(result);
        this.authenticationService.currentUser = currentUser;
        this.authenticationService.token = result.token;
        return currentUser;
      }));
  }
}
