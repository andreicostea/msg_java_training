import {Component, OnInit} from '@angular/core';
import {LoginInput} from "../../models/loginInput.model";
import {LoginService} from "../../services/login.service";
import {Alert} from "selenium-webdriver";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  private jwt: string;
  public loginInput: LoginInput = new LoginInput();

  constructor(private loginService: LoginService) {
  }

  ngOnInit() {
  }

  sendCredentials() {
    this.loginService.loginUser(this.loginInput)
      .subscribe(function (jwt) {
          console.log(jwt)
          this.jwt = jwt;

        },
        error => alert(error.error.message)
      );
  }

}
