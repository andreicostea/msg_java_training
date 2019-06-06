import {Component, OnInit} from '@angular/core';

import {ActivatedRoute, Router} from "@angular/router";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";


@Component({
  selector: 'app-bugs',
  templateUrl: './bugs.component.html',
  styleUrls: ['./bugs.component.css']
})
export class BugsComponent implements OnInit {


  constructor(private router: Router, private route: ActivatedRoute, private permissionService: AuthenticationService) { }


  ngOnInit() {
  }

  add(){
    this.router.navigate(['./insert'], {relativeTo: this.route});
  }

}
