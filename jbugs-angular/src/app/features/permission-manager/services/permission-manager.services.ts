import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/backend/backend.service";
import {Permission, PermissionJSON, Role} from "../model/permission-manager.model";

@Injectable({
  providedIn: 'root'
})
export class PermissionService {

  private usersEndpoint = 'permission';

  constructor(private backendService: BackendService) {
  }

  loadPermissionById(id: number): Observable<Permission> {
    console.log(`${environment.baseUrl}/${this.usersEndpoint}/${id}`);
    return this.backendService
      .get(`${environment.baseUrl}/${this.usersEndpoint}/${id}`)
      .pipe(map((result: PermissionJSON) => Permission.fromJSON(result)));

  }

  insertPermission(permission: Permission): Observable<any> {
    return this.backendService
      .post(`jbugs/jbugs-api/users/insert`, permission)

  }

  getRoles(roles: Role[]): Observable<any> {
    return this.backendService.get(`${environment.baseUrl}/roles/types`);
  }

  public getAllPermissions(): Observable<Permission[]> {
    return this.backendService.get('http://localhost:8080/jbugs/jbugs-api/permissions');
  }
}
