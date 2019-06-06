import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";
import {BugAddComponent} from "../../containers/bug-add/bug-add.component";
import {Bug} from "../../models/bugs.model";

@Component({
  selector: 'app-bug-dialog-add',
  templateUrl: './bug-dialog-add.component.html',
  styleUrls: ['./bug-dialog-add.component.css']
})
export class BugDialogAddComponent implements OnInit {

  bug: Bug;

  constructor(public dialog: MatDialog,
              private permissionService: AuthenticationService) { }

  ngOnInit() {
  }

  showButton() : boolean{
    // this.router.navigate(['./insert'], {relativeTo: this.route});
    if(this.permissionService.getPermissions() === null) return false;

    for(let per of this.permissionService.getPermissions())
      if(per === "BUG_MANAGEMENT") return true;
    return false;
  }


  addDialog(){
    const dialogRef = this.dialog.open(BugAddComponent , {
      width: '650px',
      height: '660px'

    });

    dialogRef.afterClosed().subscribe(result => {
      // console.log('The dialog was closed');
      this.bug = result;
    });
  }

}
