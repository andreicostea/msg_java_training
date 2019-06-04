import {Component, OnInit} from '@angular/core';
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {Permission, Role} from "../../model/permission-manager.model";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-insertpermission',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

  constructor(private router: Router, private permissionManagerServices: PermissionManagerServices) {
  }

  selectedRole: Role = <Role>{};
  roleandpermission: Subscription;
  roleandpermission2: Subscription;
  permissions = [];
  roles = [];
  selectedPermission: Permission = <Permission>{};
  ngOnInit() {
    console.log(
      this.permissionManagerServices.getAllPermissions()
        .subscribe((permissionList) => {
            this.permissions = permissionList;
          }
        ));
    this.selected();
    this.selected2();
  }

  private selected() {
    this.roleandpermission = this.permissionManagerServices.getAllPermissions()
      .subscribe(result2 => this.permissions = result2);
    console.log(this.roleandpermission);
    return this.selectedPermission;
  }

  private selected2() {
    this.roleandpermission2 = this.permissionManagerServices.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roleandpermission2);
    return this.selectedRole;
  }

  inserted() {
    this.permissionManagerServices.insertPermission(this.selectedRole.id, this.selectedPermission)
      .subscribe(value => {
          console.log(value)
        },
        error => {
          alert(error.error.message)
        });

  }
}
