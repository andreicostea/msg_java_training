import {Component, OnInit} from '@angular/core';
import {User, UserUpdate} from "../../models/users.model";
import {UsersService} from "../../services/users.service";
import {SelectionModel} from "@angular/cdk/collections";
import {MatDialog, MatDialogConfig} from "@angular/material";
import {UsersUpdateDialogComponent} from "../users-update-dialog/users-update-dialog.component";


@Component({
  selector: 'app-users-table',
  templateUrl: './users-table.component.html',
  styleUrls: ['./users-table.component.css']
})
export class UsersTableComponent implements OnInit {
  displayedColumns: string[] = ["select", "id", "firstName", "lastName", "email", "mobileNumber"];
  // dataSource: User[] = [
  //   {firstName: "Adrian", lastName: "Mutu", email: "aaa@yahoo.com", roles: ["role1", "role2"]},
  //   {firstName: "Matei", lastName: "Chivu", email: "bbb@yahoo.com", roles: ["role2", "role4"]},
  //   {firstName: "Marius", lastName: "Calin", email: "ccc@yahoo.com", roles: ["role3"]}
  // ];

  public dataSource: User[] = this.userService.loadAllUsers();
  // dataSource = new MatTableDataSource<User>(this.userService.loadAllUsers());

  public selection: SelectionModel<User> = new SelectionModel<User>(false, []);

  // /** Whether the number of selected elements matches the total number of rows. */
  // isAllSelected() {
  //   const numSelected = this.selection.selected.length;
  //   const numRows = this.dataSource.length;
  //   return numSelected === numRows;
  // }

  // /** Selects all rows if they are not all selected; otherwise clear selection. */
  // masterToggle() {
  //   console.log("hmm");
  //   this.isAllSelected() ?
  //     this.selection.clear() :
  //     this.dataSource.forEach(row => this.selection.select(row));
  // }

  /** The label for the checkbox on the passed row */
  // checkboxLabel(row?: User): string {
  //   if (!row) {
  //     return `${this.isAllSelected() ? 'select' : 'deselect'} all`;
  //   }
  //   return `${this.selection.isSelected(row) ? 'deselect' : 'select'} row ${row.position + 1}`;
  // }

  constructor(private userService: UsersService, private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  openDialog() {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;

    dialogConfig.data = this.selection.selected[0];

    const dialogRef = this.dialog.open(UsersUpdateDialogComponent, dialogConfig);

    dialogRef.afterClosed().subscribe(data => {
      if (data)
        this.userService.updateUser(new UserUpdate(data.newFirstName, data.newLastName, this.selection.selected[0].email, data.newEmail, data.newMobileNumber)).subscribe();
    });
  }

  editButtonClicked() {
    this.openDialog();
  }

  deactivateButtonClicked() {
    this.userService.deactivateUser(this.selection.selected[0].id).subscribe();
  }
}
