import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { map } from "rxjs/operators";

import { environment } from "../../../../environments/environment";
import { BackendService } from "../../../core/backend/backend.service";
import { User, UserJSON ,Role, UserUpdate} from "../models/users.model";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private usersEndpoint = 'users';

  constructor(private backendService: BackendService) { }

  loadUserByUsername(username: number): Observable<User> {
    console.log(`${environment.baseUrl}/${this.usersEndpoint}/${username}`);
    return this.backendService
      .get(`${environment.baseUrl}/${this.usersEndpoint}`);
  }

  loadUserById(id: number): Observable<User> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.usersEndpoint}/${id}`)
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

  // loadUserByUsername(username: string): Observable<User> {
  //   return this.backendService
  //     .get(`${environment.baseUrl}/${this.usersEndpoint}/${username}`)
  //     .pipe(map((result: UserJSON) => User.fromJSON(result)));
  // }
  updateUser(user: UserUpdate): Observable<any> {
    return this.backendService.patch(`${environment.baseUrl}/${this.usersEndpoint}`, user);
  }

  deactivateUser(id: number): Observable<any> {
    return this.backendService.delete(`${environment.baseUrl}/${this.usersEndpoint}/${id}`);
  }

  loadAllUsers() : User[] {
    return this.backendService.get(`${environment.baseUrl}/${this.usersEndpoint}`);
  }
}
