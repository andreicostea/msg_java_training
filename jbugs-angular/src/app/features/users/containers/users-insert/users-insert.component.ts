import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {UsersService} from "../../services/users.service";
import {Role, User} from "../../models/users.model";
import {UsersInsertButtonComponent} from "../../components/users-insert-button/users-insert-button.component";
import {MatDialogRef} from "@angular/material";


@Component({
  selector: 'app-users-insert',
  templateUrl: './users-insert.component.html',
  styleUrls: ['./users-insert.component.css']
})
export class UsersInsertComponent implements OnInit {


  roles: Role[];


  public user: User = new User();

  constructor(private router: Router, private userService: UsersService,
              public dialogRef: MatDialogRef<UsersInsertButtonComponent>) {


  }

  ngOnInit() {
    this.userService.getRoles(this.roles).subscribe(role => this.roles = role,
      error => console.log(error));

  }


  insert() {
    console.log(this.user);
    this.userService.insertUser(this.user).subscribe((
        value => {
          this.onNoClick();
        }),
      (error => {
        alert(error.error.message)
      }),
      () => {
        this.router.navigate(['/dashboard'])
      })
    ;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }


}

