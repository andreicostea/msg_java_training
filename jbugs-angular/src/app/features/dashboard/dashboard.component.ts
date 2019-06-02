import { Component, OnInit } from '@angular/core';
import { UsersService } from "../users/services/users.service";

import {CookieService} from "ngx-cookie-service";
import {PermissionsService} from "../../core/permissions/permissions.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private cookieService: CookieService,private permissionService: PermissionsService) { }

  ngOnInit() {
  }
  test(){

    console.log(this.permissionService.getPermissions())

  }
}
