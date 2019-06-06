import {Component, OnInit} from '@angular/core';
import {LoginInput} from "../../models/loginInput.model";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";
import {MatDialog} from "@angular/material";
import {DialogComponent} from "../dialog/dialog.component";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";


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


  constructor(public dialog: MatDialog,private router: Router,private loginService: LoginService, private authenticationService: AuthenticationService) {
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
            data: {name: "Hello "+that.authenticationService.getUserName()}
          });
          that.router.navigate(['/dashboard'])

          },
        error => {
          console.log(error)
          that.dialog.open(DialogComponent, {
            width: '250px',
            data: {name: error.error.message}
          })
        }
      );

  }

}
