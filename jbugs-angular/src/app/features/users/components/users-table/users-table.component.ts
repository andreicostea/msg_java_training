import {Component, OnInit} from '@angular/core';
import {User, UserJSON} from "../../models/users.model";
import {UsersService} from "../../services/users.service";
import {Observable} from "rxjs";


@Component({
  selector: 'app-users-table',
  templateUrl: './users-table.component.html',
  styleUrls: ['./users-table.component.css']
})
export class UsersTableComponent implements OnInit {
  displayedColumns: string[] = ["firstName", "lastName", "email", "mobileNumber"];
  // dataSource: User[] = [
  //   {firstName: "Adrian", lastName: "Mutu", email: "aaa@yahoo.com", roles: ["role1", "role2"]},
  //   {firstName: "Matei", lastName: "Chivu", email: "bbb@yahoo.com", roles: ["role2", "role4"]},
  //   {firstName: "Marius", lastName: "Calin", email: "ccc@yahoo.com", roles: ["role3"]}
  // ];
  dataSource: Observable<User[]> = this.loadAllUsers();

  private loadAllUsers() {
    return this.userService.loadAllUsers();
  }

  constructor(private userService: UsersService) {
  }

  ngOnInit() {
  }

}
