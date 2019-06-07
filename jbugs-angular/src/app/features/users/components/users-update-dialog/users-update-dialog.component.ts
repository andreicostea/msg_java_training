import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {User} from "../../models/users.model";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-users-update-dialog',
  templateUrl: './users-update-dialog.component.html',
  styleUrls: ['./users-update-dialog.component.css']
})
export class UsersUpdateDialogComponent implements OnInit {

  form: FormGroup;
  user: User;

  constructor(private fb: FormBuilder, private dialogRef: MatDialogRef<UsersUpdateDialogComponent>, @Inject(MAT_DIALOG_DATA) data) {
    this.user = data;
    this.form = fb.group({
      newFirstName: [this.user.firstName],
      newLastName: [this.user.lastName],
      newEmail: [this.user.email],
      newMobileNumber: [this.user.mobileNumber],
      newStatus: [this.user.status]
    });
  }

  ngOnInit() {
  }

  close() {
    this.dialogRef.close();
  }

  update() {
    this.dialogRef.close(this.form.value);
  }
}
