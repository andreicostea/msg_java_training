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

  selectedRole: Role = <Role>{};
  roleandpermission2: Subscription;
  roles = [];
  selection: Permission = <Permission>{};
  permissions = [
    {
      id: 1,
      type: 'PERMISSION_MANAGEMENT',
      description: 'Can add or remove permissions'
    },
    {
      id: 3,
      type: 'USER_MANAGEMENT',
      description: 'Can make the CRUD operations for a user'
    },
    {
      id: 4,
      type: 'BUG_MANAGEMENT',
      description: 'Can make the CRUD operations for a bug+export the list of bugs in pdf'
    },
    {
      id: 5,
      type: 'BUG_CLOSE',
      description: 'Closing the bug and updating a status '
    },
    {
      id: 6,
      type: 'BUG_EXPORT_PDF',
      description: 'Can exporting the list of bugs'
    },
    {
      id: 7,
      type: 'USER_ADDRESS',
      description: 'Just the user address can see the notification'
    }
  ];
  inserted() {
    this.permissionManagerServices.insertPermission(this.selectedRole.id, this.selection)
      .subscribe(
        value => this.dialogRef.close(),
        error => {
          alert(error.error.message)
        });
  }

  ngOnInit() {
    console.log(
      this.selected2());
  }

  private selected2() {
    this.roleandpermission2 = this.permissionManagerServices.getAllRolesAndPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roleandpermission2);
    return this.selectedRole;
  }
}
