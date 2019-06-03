import {Component, OnInit} from '@angular/core';
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {Permission} from "../../model/permission-manager.model";
import {Subscription} from "rxjs";
import {Router} from "@angular/router";

@Component({
  selector: 'app-insertpermission',
  templateUrl: './insertorremovepermission.component.html',
  styleUrls: ['./insertorremovepermission.component.css']
})
export class InsertorremovepermissionComponent implements OnInit {

  constructor(private router: Router, private permissionManagerServices: PermissionManagerServices) {
  }

  public permissionList: Permission[];
  roleandpermission: Subscription;
  permissionss = new Permission;
  permissions = [];
  roles = [];
  selection = {};
  ngOnInit() {
    console.log(
      this.permissionManagerServices.getAllPermissions()
        .subscribe((permissionList) => {
            this.permissions = permissionList;
          }
        ));
    this.selected();
  }

  private selected() {
    this.roleandpermission = this.permissionManagerServices.getAllPermissions()
      .subscribe(result => this.roles = result);
    console.log(this.roleandpermission);
    return this.selection;
  }

  id: number;

  inserted(id: any, roles: any[]) {
    console.log(this.permissionss);
    this.permissionManagerServices.insertPermission(this.id, this.permissionss)
      .subscribe(value => {
          console.log(value)
        },
        error => {
          console.log(error.error.message)
        },
        () => {
          // this.router.navigate(['/dashboard'])
        });
  }
}
