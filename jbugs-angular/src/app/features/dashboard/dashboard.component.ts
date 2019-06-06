import {Component, OnInit} from '@angular/core';

import {CookieService} from "ngx-cookie-service";
import {AuthenticationService} from "../../core/services/authentication/authentication.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private userName:String;
  constructor(private cookieService: CookieService, private permissionService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.userName = this.permissionService.getUserName();
  }



  logout(){
    localStorage.removeItem("api-token");
    this.router.navigate(['login']);

  }
}
