import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {PermissionsService} from "../../../../core/permissions/permissions.service";

@Component({
  selector: 'app-permission-manager',
  templateUrl: './permission-manager.component.html',
  styleUrls: ['./permission-manager.component.css']
})
export class PermissionManagerInsertComponent implements OnInit {
  constructor(private permissionService: PermissionsService,
              private servicePermission: PermissionManagerServices,
              private activateRouter: ActivatedRoute,
              private router: Router) {
  }
  ngOnInit() {
  }
}
