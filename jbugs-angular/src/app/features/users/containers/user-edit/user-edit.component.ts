import {Component, OnInit} from '@angular/core';
import {User} from "../../models/users.model";
import {UsersService} from "../../services/users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {

  private user = new User();

  constructor(private userService: UsersService, private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit(formData) {
    this.user.firstName = formData.firstName;
    this.user.lastName = formData.lastName;
    this.user.email = formData.email;
    this.user.mobileNumber = formData.mobileNumber;
    this.userService.updateUser(this.user);
    this.router.navigateByUrl("dashboard/users");
  }
}
