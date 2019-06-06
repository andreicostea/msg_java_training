import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UsersInsertComponent} from "../../containers/users-insert/users-insert.component";
import {MatDialog} from "@angular/material";
import {User} from "../../models/users.model";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";

@Component({
  selector: 'app-users-insert-button',
  templateUrl: './users-insert-button.component.html',
  styleUrls: ['./users-insert-button.component.css']
})
export class UsersInsertButtonComponent implements OnInit {

  user: User;


  constructor(private router: Router, private route: ActivatedRoute, public dialog: MatDialog,
              private permissionService: AuthenticationService) { }

  ngOnInit() {
  }

  showButton() : boolean{
   // this.router.navigate(['./insert'], {relativeTo: this.route});
   if(this.permissionService.getPermissions() === null) return false;
   //console.log(this.permissionService.getPermissions());

   for(let per of this.permissionService.getPermissions())
     if(per === "USER_MANAGEMENT") return true;
    return false;
  }


  addDialog(){
    const dialogRef = this.dialog.open(UsersInsertComponent, {
      width: '590px',
      height: '560px'

    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      this.user = result;
    });
  }


}
