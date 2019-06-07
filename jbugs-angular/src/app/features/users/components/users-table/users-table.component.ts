import {Component, Input, OnInit} from '@angular/core';
import {User, UserUpdate} from "../../models/users.model";
import {UsersService} from "../../services/users.service";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {UsersUpdateDialogComponent} from "../users-update-dialog/users-update-dialog.component";


@Component({
  selector: 'app-users-table',
  templateUrl: './users-table.component.html',
  styleUrls: ['./users-table.component.css']
})
export class UsersTableComponent implements OnInit {
  displayedColumns: string[] = ["id", "firstName", "lastName", "email", "mobileNumber", "actions"];

  @Input()
  dataSource: User[];

  public dataSource: User[] = this.userService.loadAllUsers();

  // dataSource = new MatTableDataSource<User>(this.userService.loadAllUsers());

  constructor(private userService: UsersService, private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  openDialog(user: User) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = user;

    const dialogRef = this.dialog.open(UsersUpdateDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(updatedUser => {
      if (updatedUser) {
        console.log(updatedUser);
        console.log(user.email);
        this.userService.updateUser(new UserUpdate(updatedUser.newFirstName, updatedUser.newLastName, user.email, updatedUser.newEmail, updatedUser.newMobileNumber, updatedUser.newStatus)).subscribe();
      }
    });
  }

  editButtonClicked(user: User) {
    this.openDialog(user);
  }

  deactivateButtonClicked(user: User) {
    this.userService.deactivateUser(user.id).subscribe();
  }
}
