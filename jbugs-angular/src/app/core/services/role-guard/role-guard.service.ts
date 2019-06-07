import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from "@angular/router";
import {Observable} from "rxjs";

import {MatDialog} from "@angular/material";


import {DialogComponent} from "../../../features/login/components/dialog/dialog.component";
import {AuthenticationService} from "../authentication/authentication.service";


@Injectable({
  providedIn: 'root'
})
export class RoleGuardService {

  constructor(private dialog: MatDialog, private authenticationService: AuthenticationService, private router: Router) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    for (let per of this.authenticationService.getPermissions()) {
      if (per === next.data.permission) {
        return true;
      }
    }

    // navigate to not found page
    this.dialog.open(DialogComponent, {
      width: '250px',
      data: {name: "You don't have permission of " + next.data.permission}
    });
    this.router.navigate(['/dashboard']);
    return false;
  }
}
