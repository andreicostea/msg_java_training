import { Injectable } from '@angular/core';
import {BackendService} from "../../../core/backend/backend.service";
import {Observable} from "rxjs";
import {User, UserJSON} from "../../users/models/users.model";
import {environment} from "../../../../environments/environment";
import {map} from "rxjs/operators";
import {LoginInput} from "../models/loginInput.model";
import {HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private loginEndpoint = 'auth';

  constructor(private backendService: BackendService) { }

  loginUser(loginInput: LoginInput):Observable<String> {
    const requestOptions: Object = {
      /* other options here */
      responseType: 'text'
    }
    return this.backendService
      .post(`${environment.baseUrl}/${this.loginEndpoint}/`,loginInput,"",requestOptions)
      .pipe(map((result: string)  => result));
  }
}
