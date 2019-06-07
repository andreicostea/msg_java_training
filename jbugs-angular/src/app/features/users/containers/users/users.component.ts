import {Component, OnInit} from '@angular/core';
import {UsersService} from "../../services/users.service";
import {User} from "../../models/users.model";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  user: User;

  constructor(private userService: UsersService) {
  }

  get currentUser(): string {
    return this.user ? JSON.stringify(this.user) : '';
  }

  ngOnInit() {

  }


}
