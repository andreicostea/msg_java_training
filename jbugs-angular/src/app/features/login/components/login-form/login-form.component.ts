import {Component, OnInit} from '@angular/core';
import {LoginInput} from "../../models/loginInput.model";
import {LoginService} from "../../services/login.service";
import {CookieService} from "ngx-cookie-service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material";
import {DialogComponent} from "../dialog/dialog.component";
import {PermissionsService} from "../../../../core/permissions/permissions.service";

export interface DialogData {
  animal: string;
  name: string;
}
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {


  public loginInput: LoginInput = new LoginInput();


  constructor(public dialog: MatDialog,private router: Router,private loginService: LoginService, private permissionService: PermissionsService) {
  }

  ngOnInit() {
  }

  sendCredentials() {
    var that = this;
    this.loginService.loginUser(this.loginInput)
      .subscribe(
        function (result) {
          localStorage.setItem('api-token', result.token);
          that.dialog.open(DialogComponent, {
            width: '250px',
            data: {name: that.permissionService.getUserName()}
          });
          that.router.navigate(['/dashboard'])

          },
        error => alert(error.error.message)
      );
  }

}
