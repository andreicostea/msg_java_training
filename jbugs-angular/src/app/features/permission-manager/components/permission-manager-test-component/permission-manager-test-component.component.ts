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

  // TODO add role type instead of 'any'
  selection = {};

  constructor(private permissionservice: PermissionService) {
  }

  ngOnInit() {
    this.permissionservice.getAllPermissions()
      .subscribe((permissionList) => {
        this.permissionList = permissionList;
      });
  }

  roles = [
    {
      id: 1,
      name: 'ADMINISTRATOR',
      permissionList: [{type: 'PERMISSION_MANAGER', description: 'blabla'}, {
        type: 'BUG_MANAGER',
        description: 'blabla2'
      }]
    },
    {id: 2, name: 'PROJECT MANAGER', permissionList: [{type: 'BUG_MANAGER', description: 'blabla2'}]},
    {
      id: 3,
      name: 'TEST MANAGER',
      permissionList: [{type: 'PERMISSION_MANAGER', description: 'blabla'}, {
        type: 'BUG_MANAGER',
        description: 'blabla2'
      }]
    },
    {
      id: 4,
      name: 'DEVELOPER',
      permissionList: [{type: 'PERMISSION_MANAGER', description: 'blabla'}, {
        type: 'BUG_MANAGER',
        description: 'blabla2'
      }]
    },
    {
      id: 5,
      name: 'TESTER',
      permissionList: [{type: 'PERMISSION_MANAGER', description: 'blabla'}, {
        type: 'BUG_MANAGER',
        description: 'blabla2'
      }]
    }
  ];

  get selected() {
    console.log(this.selection);
    return this.selection;
  }
}
