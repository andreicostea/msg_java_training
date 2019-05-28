import { Component, OnInit } from '@angular/core';
import { LoginService } from "../../services/login.service"
import {LoginInput} from "../../models/loginInput.model";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
