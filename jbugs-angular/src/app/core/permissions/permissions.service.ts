import { Injectable } from '@angular/core';
import * as jwt_decode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class PermissionsService {

  constructor() {
  }

  private decode(token: string) {
    try {
      return jwt_decode(token);
    } catch (Error) {
      return null;
    }
  }

  public getPermissions() {

    let token = localStorage.getItem('api-token');
    return (this.decode(token).permissions)
  }


  public getUserId(){
    let token = localStorage.getItem('api-token');
    return(this.decode(token).id)
  }

  public getUserName() {
    let token = localStorage.getItem('api-token');
    return (this.decode(token).username)
  }
  public getToken() {
    return localStorage.getItem('api-token');
  }
}
