import { Injectable } from '@angular/core';
import {MatDialog} from "@angular/material";

import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";
import {DialogComponent} from "../../../features/login/components/dialog/dialog.component";
import {AuthenticationService} from "../authentication/authentication.service";



@Injectable({
  providedIn: 'root'
})
export class LoginGuardService {


  constructor(private dialog: MatDialog, private authenticationService: AuthenticationService, private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.authenticationService.getToken() !== null ) {
      const found = this.authenticationService.getPermissions().some(r => next.data.permission.indexOf(r) >= 0)
      if (found === true) {
        console.log(found)
        return true
      } else {
        this.router.navigate(['/login']);
        return false
      }
    }
  else {
      this.router.navigate(['/login']);
      return false
    }

  }

}


