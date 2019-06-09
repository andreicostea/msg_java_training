import {Component, Input} from '@angular/core';
import {User, UserUpdate} from "../../models/users.model";
import {UsersService} from "../../services/users.service";
import {MatDialog, MatDialogConfig, MatSnackBar} from "@angular/material";
import {UsersUpdateDialogComponent} from "../users-update-dialog/users-update-dialog.component";


@Component({
  selector: 'app-users-table',
  templateUrl: './users-table.component.html',
  styleUrls: ['./users-table.component.css']
})
export class UsersTableComponent {
  displayedColumns: string[] = ["id", "firstName", "lastName", "email", "mobileNumber", "actions"];

  @Input()
  dataSource: User[];

  constructor(private userService: UsersService, private dialog: MatDialog, private snackbar: MatSnackBar) {
  }

  openDialog(user: User) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = user;

    const dialogRef = this.dialog.open(UsersUpdateDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(updatedUser => {
      if (updatedUser) {
        this.userService.updateUser(new UserUpdate(updatedUser.newFirstName, updatedUser.newLastName, user.email, updatedUser.newEmail, updatedUser.newMobileNumber, updatedUser.newStatus, updatedUser.newRoles))
          .subscribe();
        window.location.reload();
      }
    });
  }

  editButtonClicked(user: User) {
    this.openDialog(user);
  }

  deactivateButtonClicked(user: User) {
    this.userService.deactivateUser(user.id)
      .subscribe(any => {
          window.location.reload();
        },
        error1 => {
          this.snackbar.open("ERROR: " + error1.error.message, null, {duration: 2000});
        }
      );
  }
}
