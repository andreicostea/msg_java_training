import {Component, OnInit} from '@angular/core';
import {PermissionService} from "../../services/permission-manager.services";
import {Permission} from "../../model/permission-manager.model";

@Component({
  selector: 'app-permission-manager-test-component',
  templateUrl: './permission-manager-test-component.component.html',
  styleUrls: ['./permission-manager-test-component.component.css']
})
export class PermissionManagerInsertButtonComponent implements OnInit {
  public permissionList: Permission[];

  constructor(private permissionservice: PermissionService) {
  }

  ngOnInit() {
    this.permissionservice.getAllPermissions()
      .subscribe((permissionList) => {
        this.permissionList = permissionList;
      });
  }

  roles = [
    {id: 1, name: 'ADMINISTRATOR'},
    {id: 2, name: 'PROJECT MANAGER'},
    {id: 3, name: 'TEST MANAGER'},
    {id: 4, name: 'DEVELOPER'},
    {id: 5, name: 'TESTER'}];
}
