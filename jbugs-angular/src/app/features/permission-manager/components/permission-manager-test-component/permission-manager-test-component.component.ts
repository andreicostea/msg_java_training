import {Component, OnInit} from '@angular/core';
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {Permission, Role} from "../../model/permission-manager.model";
import {PermissionsService} from "../../../../core/permissions/permissions.service";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-permission-manager-test-component',
  templateUrl: './permission-manager-test-component.component.html',
  styleUrls: ['./permission-manager-test-component.component.css']
})
export class PermissionManagerInsertButtonComponent implements OnInit {
  public userPermission: string[];
  private response: boolean;
  public roleandpermission: Subscription;
  selectedRole: Role = <Role>{};
  selectedPermission: Permission = <Permission>{};
  constructor(private permissionService: PermissionsService,
              private permissionManagerService: PermissionManagerServices,
              private activateRouter: ActivatedRoute,
              private router: Router) {
  }
  ngOnInit() {
    console.log(
      this.permissionManagerService.getAllRolesAndPermissions()
        .subscribe((permissionList) => {
            this.permissions = permissionList;
          }
        ));
    this.getPermissions();
    this.selected();
  }
  roles = [];
  permissions = [];
  private selected() {
    this.roleandpermission = this.permissionManagerService.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roles);
    console.log(this.roleandpermission);
    return this.selectedRole;
  }
  private getPermissions() {
    this.userPermission = this.permissionService.getPermissions();
    console.log(this.userPermission);
    this.response = this.userPermission.includes('PERMISSION_MANAGEMENT');
    console.log(this.response);
  }
  addPermission(): void {
    this.router.navigate(['./insert'], {relativeTo: this.activateRouter});
  }
  deletePermission() {
    this.permissionManagerService.deletePermission(this.selectedPermission.id)
      .subscribe(
        value => {
          this.permissionManagerService.getAllRolesAndPermissions()
            .subscribe(result => {
              this.roles = result;
              for (const role of result) {
                if (this.selectedRole.id === role.id) {
                  return this.selectedRole = role;
                }
              }
            });
        },
        error1 => alert("error")
      );
  }
}