import { Component, OnInit } from '@angular/core';
import { UsersService } from "../services/users.service";
import { User } from "../models/users.model";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  user: User;
  // users: User[];

  constructor(private userService: UsersService) { }

  ngOnInit() {
    // //TODO integrate with login
    // this.userService.loadUserByUsername('admin')
    //   .subscribe(
    //     user => this.user = user,
    //     error => console.log(error)
    //     );

    // this.userService.loadUserById(1)
    //   .subscribe(
    //     user => this.user = user,
    //     error => console.log(error)
    //   );
  }

  get currentUser(): string {
    return this.user ? JSON.stringify(this.user) : '';
  }

  activateButtonClicked() {
    console.log("Activate button clicked!");
    // this.userService.activateUser();
  }
}
