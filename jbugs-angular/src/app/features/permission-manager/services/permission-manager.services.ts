import {Injectable} from '@angular/core';
import {Observable} from "rxjs";

import {environment} from "../../../../environments/environment";
import {BackendService} from "../../../core/backend/backend.service";
import {Permission, PermissionJSON, Role, RoleJSON} from "../model/permission-manager.model";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class PermissionManagerServices {

  private rolesEndpoint = 'roles';
  private permissionsEndpoint = 'permissions';

  constructor(private backendService: BackendService) {
  }

  loadPermissionById(id: number): Observable<Permission> {
    console.log(`${environment.baseUrl}/${this.rolesEndpoint}/${id}`);
    return this.backendService
      .get(`${environment.baseUrl}/${this.rolesEndpoint}/${id}`)
      .pipe(map((result: PermissionJSON) => Permission.fromJSON(result)));
  }

  insertPermission(id: number, permission: Permission): Observable<Permission> {
    return this.backendService
      .post(`${environment.baseUrl}/${this.rolesEndpoint}/${id}`, permission);
  }

  deletePermission(id: number): Observable<Permission> {
    return this.backendService.delete(`${environment.baseUrl}/${this.permissionsEndpoint}/${id}`);
  }

  // getRoles(roles: Role[]): Observable<any> {
  //   return this.backendService.get(`${environment.baseUrl}/roles/types/id`);
  // }

  public getAllRolesAndPermissions(): Observable<RoleJSON[]> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.rolesEndpoint}`);
  }

  public getAllPermissions(): Observable<PermissionJSON[]> {
    return this.backendService
      .get(`${environment.baseUrl}/${this.permissionsEndpoint}`);
  }

}
