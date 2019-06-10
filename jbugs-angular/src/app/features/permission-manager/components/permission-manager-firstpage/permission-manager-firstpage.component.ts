import {Component, OnInit} from '@angular/core';
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {Permission, Role} from "../../model/permission-manager.model";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {MatDialog} from "@angular/material";
import {InsertComponent} from "../../containers/addpermission/insert.component";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";

@Component({
  selector: 'app-permission-manager-firstpage',
  templateUrl: './permission-manager-firstpage.component.html',
  styleUrls: ['./permission-manager-firstpage.component.css']
})
export class PermissionManagerInsertButtonComponent implements OnInit {
  public userPermission: string[];
  public roleandpermission: Subscription;
  selectedRole: Role = <Role>{};
  selectedPermission: Permission = <Permission>{};

  constructor(private permissionService: AuthenticationService,
              private permissionManagerService: PermissionManagerServices,
              private activateRouter: ActivatedRoute,
              private router: Router,
              public dialog: MatDialog) {
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

  // }
  deletePermission() {
    this.permissionManagerService.deletePermission(this.selectedPermission.id)
      .subscribe(
        value => this.reloadRolesandPermissions(),
        error1 => alert(error1.error.message)
      );
  }

  showButton(): boolean {
    if (this.authenticationService.getPermissions() === null) return false;
    for (let per of this.authenticationService.getPermissions())
      if (per === "PERMISSION_MANAGEMENT") return true;
    return false;
  }

  // addPermission(): void {
  //   this.router.navigate(['./insert'], {relativeTo: this.activateRouter});

  addDialog() {
    const dialogRef = this.dialog.open(InsertComponent, {
      width: '590px',
      height: '560px'

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.permissions = result;
      this.reloadRolesandPermissions();
    });
  }

  private selected() {
    this.roleandpermission = this.permissionManagerService.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roles);
    console.log(this.roleandpermission);
    return this.selectedRole;
  }

  private getPermissions() {
    this.userPermission = this.authenticationService.getPermissions();
    console.log(this.userPermission);
    this.response = this.userPermission.includes('PERMISSION_MANAGEMENT');
    console.log(this.response);
  }

  private reloadRolesandPermissions() {
    this.permissionManagerService.getAllRolesAndPermissions()
      .subscribe(result => {
        this.roles = result;
        for (const role of result) {
          if (this.selectedRole.id === role.id) {
            return this.selectedRole = role;
          }
        }
      });
  }
}
