import { Component, OnInit } from '@angular/core';
import { UsersService } from "../users/services/users.service";

import {CookieService} from "ngx-cookie-service";
import {PermissionsService} from "../../core/permissions/permissions.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private userName:String;
  constructor(private cookieService: CookieService,private permissionService: PermissionsService,private router: Router) { }

  ngOnInit() {
    this.userName = this.permissionService.getUserName();
  }
  test(){
    console.log(this.permissionService.getUserName())
    console.log(this.permissionService.getPermissions());
  }
  
  logout(){
    localStorage.removeItem("api-token");
    this.router.navigate(['login']);

  }
}
