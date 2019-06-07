import {Component, Inject, OnInit} from '@angular/core';
import {Bug} from "../../models/bugs.model";
import {User} from "../../../users/models/users.model";
import {BugsService} from "../../services/bugs.service";
import {Router} from "@angular/router";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

import {UsersService} from "../../../users/services/users.service";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";

@Component({
  selector: 'app-bug-view',
  templateUrl: './bug-view.component.html',
  styleUrls: ['./bug-view.component.css']
})

export class BugViewComponent implements OnInit {

  bug: Bug;
  usersList: User[];

  constructor(private bugService: BugsService, private router: Router, public dialogRef: MatDialogRef<BugViewComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any, public authService: AuthenticationService, private userService: UsersService) {
  }

  ngOnInit() {
    this.userService.getAllUsers().subscribe(users => this.usersList = users,
      error => console.log(error));

    this.bug = this.data;
    console.log(this.bug.title);
  }

  insert() {
    this.bug.CREATED_ID = this.authService.getUserId();
    this.bugService.insertBug(this.bug).subscribe((
        value => {
          this.onNoClick();
        }),
      (error => {
        alert(error.error.message)
      }),
      () => {
        this.router.navigate(['/dashboard/bugs'])
      });
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
