import {Injectable} from '@angular/core';
import {BackendService} from "../../../core/backend/backend.service";
import {Observable} from "rxjs";

import {environment} from "../../../../environments/environment";
import {map} from "rxjs/operators";
import {LoginInput} from "../models/loginInput.model";
import {User} from "../../users/models/users.model";


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginEndpoint = 'auth';

  constructor(private backendService: BackendService) {
  }

  loginUser(loginInput: LoginInput): Observable<User> {
    return this.backendService
      .post(`${environment.loginUrl}/${this.loginEndpoint}/`, loginInput)
      .pipe(map((result: User) => User.fromJSON(result)));
  }
}
