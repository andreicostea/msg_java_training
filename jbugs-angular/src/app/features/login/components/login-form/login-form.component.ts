import {Component, OnInit} from '@angular/core';
import {LoginInput} from "../../models/loginInput.model";
import {LoginService} from "../../services/login.service";

import {Alert} from "selenium-webdriver";
import {CookieService} from "ngx-cookie-service";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private jwt: string;
  public loginInput: LoginInput = new LoginInput();

  constructor(private loginService: LoginService,private cookieService: CookieService) {
  }

  ngOnInit() {
  }

  sendCredentials() {
    var that = this;
    this.loginService.loginUser(this.loginInput)
      .subscribe(
        function (result) {

          that.cookieService.set( 'Test', result.token)

        },
        error => alert(error.error.message)
      );
  }

}
