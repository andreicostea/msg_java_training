import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PermissionsService} from "../../../../core/permissions/permissions.service";

@Component({
  selector: 'app-bugs',
  templateUrl: './bugs.component.html',
  styleUrls: ['./bugs.component.css']
})
export class BugsComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute, private permissionService: PermissionsService) { }

  ngOnInit() {
  }

  add(){
    this.router.navigate(['./insert'], {relativeTo: this.route});
  }




}
