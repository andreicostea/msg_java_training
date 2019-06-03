import {Injectable} from '@angular/core';

import * as jwt_decode from 'jwt-decode'
import {CookieService} from "ngx-cookie-service";


@Injectable({
  providedIn: 'root'
})
export class PermissionsService {

  constructor(private cookieService: CookieService) {
  }

  private decode(token: string) {
    try {
      return jwt_decode(token);
    } catch (Error) {
      return null;
    }
  }

  public getPermissions() {
    let token = this.cookieService.get('Test');
    return (this.decode(token).permissions)
  }

}
