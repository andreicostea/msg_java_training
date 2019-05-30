import {Component, OnInit} from '@angular/core';
import {UsersService} from "../../services/users.service";
import {User} from "../../models/users.model";
import {Router} from "@angular/router";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  user: User;

  // users: User[];

  constructor(private userService: UsersService, private router: Router) {
  }

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

  editButtonClicked() {
    this.router.navigateByUrl("dashboard/users/edit");
  }
}
