import {AfterViewInit, Component, Inject, OnInit} from '@angular/core';
import {BugsService} from "../../services/bugs.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

import {UsersService} from "../../../users/services/users.service";
import {Bug} from "../../models/bugs.model";

import {User} from "../../../users/models/users.model";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";

@Component({
  selector: 'app-bug-edit',
  templateUrl: './bug-edit.component.html',
  styleUrls: ['./bug-edit.component.css']
})
export class BugEditComponent implements OnInit {

  bug: Bug;
  usersList: User[];
  status: any;


  constructor(private bugService: BugsService, private router: Router, public dialogRef: MatDialogRef<BugEditComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public authService: AuthenticationService, private userService: UsersService) {
  }

  ngOnInit() {
    this.userService.getAllUsers().subscribe(users => this.usersList = users,
      error => console.log(error));


    this.bug = this.data;

  }


  editBug() {

    console.log(this.usersList);

    console.log(this.bug.status);

    this.bugService.editBug(this.bug).subscribe((
        value => {
          this.onNoClick();
        }),
      (error => {
        alert(error.error.message)
      }),
      () => {
        this.router.navigate(['/dashboard/bugs'])
      })
    ;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }



}
