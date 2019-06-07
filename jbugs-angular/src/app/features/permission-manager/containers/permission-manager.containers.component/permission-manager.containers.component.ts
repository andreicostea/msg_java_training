import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PermissionManagerServices} from "../../services/permission-manager.services";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";

@Component({
  selector: 'app-permission-manager',
  templateUrl: './permission-manager.containers.component.html',
  styleUrls: ['./permission-manager.containers.component.css']
})
export class PermissionManagerInsertComponent implements OnInit {
  constructor(private permissionService: AuthenticationService,
              private servicePermission: PermissionManagerServices,
              private activateRouter: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
  }
}
