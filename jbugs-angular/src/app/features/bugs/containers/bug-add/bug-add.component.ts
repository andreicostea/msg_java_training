import { Component, OnInit } from '@angular/core';
import {Bug} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Router} from "@angular/router";
import {PermissionsService} from "../../../../core/permissions/permissions.service";


@Component({
  selector: 'app-bug-add',
  templateUrl: './bug-add.component.html',
  styleUrls: ['./bug-add.component.css']
})
export class BugAddComponent implements OnInit {



 public bug : Bug = new Bug();

  constructor(private bugService : BugsService, private router : Router,  private permissionService: PermissionsService) { }

  ngOnInit() {
  }

  insert(){
    this.bug.CREATED_ID = this.permissionService.getUserId();
    console.log(this.bug);
    this.bugService.insertBug(this.bug).subscribe((
        value => {console.log(value)}),
      (error => {alert(error.error.message)} ),
      () => {this.router.navigate(['/dashboard'])})
    ;
  }

}
