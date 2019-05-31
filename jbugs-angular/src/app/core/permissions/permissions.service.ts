import { Injectable } from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class PermissionsService {

  constructor(private cookieService: CookieService) {
  }

  private decode(token:string){
    try{
      return jwt_decode(token);
    }
    catch(Error){
      return null;
    }
  }
  public getPermissions(){
    let token = this.cookieService.get('Test');
   return(this.decode(token).permissions)
  }

public getToken(){
  return this.cookieService.get('Test');
}

  public getUserId(){
    let token = this.cookieService.get('Test');
    return(this.decode(token).id)
  }
}
