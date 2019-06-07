import {Component, OnInit} from '@angular/core';
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {Permission, Role} from "../../model/permission-manager.model";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {MatDialogRef} from "@angular/material";
import {PermissionManagerInsertButtonComponent} from "../../components/permission-manager-firstpage/permission-manager-firstpage.component";

@Component({
  selector: 'app-insertpermission',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {

  constructor(
    private router: Router,
    private permissionManagerServices: PermissionManagerServices,
    private dialogRef: MatDialogRef<PermissionManagerInsertButtonComponent>
  ) {}
  selectedRole: Role = <Role>{};
  selectedRole2: Role = <Role>{};
  roleandpermission2: Subscription;
  roles = [];
  selection: Permission = <Permission>{};
  ngOnInit() {
    console.log(
      this.selected2());
  }
  private selected2() {
    this.roleandpermission2 = this.permissionManagerServices.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roleandpermission2);
    return this.selectedRole2;
  }

  inserted() {
    this.permissionManagerServices.insertPermission(this.selectedRole.id, this.selection)
      .subscribe(
        value => this.dialogRef.close(),
        error => {
          alert(error.error.message)
        });
  }
  permissions = [
    {
      id: 1,
      type: 'PERMISSION_MANAGEMENT',
      description: 'Permission stuff'
    },
    {
      id: 3,
      type: 'USER_MANAGEMENT',
      description: 'Bug stuff'
    },
    {
      id: 4,
      type: 'BUG_MANAGEMENT',
      description: 'Bug stuff'
    },
    {
      id: 5,
      type: 'BUG_CLOSE',
      description: 'Can close some bugs'
    },
    {
      id: 6,
      type: 'BUG_EXPLORE_PDF',
      description: 'exploring bugs'
    },
    {
      id: 7,
      type: 'USER_ADDRESS',
      description: 'addressing some users'
    }
  ];

  constructor(private router: Router, private permissionManagerServices: PermissionManagerServices) {
  }

  ngOnInit() {
    console.log(
      this.selected2());
  }

  inserted() {
    this.permissionManagerServices.insertPermission(this.selectedRole.id, this.selection)
      .subscribe(value => {
          console.log(value)
        },
        error => {
          alert(error.error.message)
        });

  }

  private selected2() {
    this.roleandpermission2 = this.permissionManagerServices.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roleandpermission2);
    return this.selectedRole;
  }
}
