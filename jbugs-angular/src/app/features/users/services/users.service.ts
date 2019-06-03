import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { environment } from "../../../../environments/environment";
import { BackendService } from "../../../core/backend/backend.service";
import {Role, User, UserJSON} from "../models/users.model";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private usersEndpoint = 'users';

  constructor(private backendService: BackendService) { }

  loadUserByUsername(username: number): Observable<User> {
    console.log(`${environment.baseUrl}/${this.usersEndpoint}/${username}`);
    return this.backendService
      .get(`${environment.baseUrl}/${this.usersEndpoint}/${username}`)
      .pipe(map((result: UserJSON) => User.fromJSON(result)));

  }

  insertUser(user: User) : Observable<any> {
    return  this.backendService
      .post(`jbugs/jbugs-api/users/insert`, user)

  }

  getRoles(roles: Role[]) : Observable<any> {
    return  this.backendService.get(`${environment.baseUrl}/roles/types`);
  }

  getAllUsers() :Observable<any>{
    return  this.backendService.get(`${environment.baseUrl}/${this.usersEndpoint}`);
  }
}
