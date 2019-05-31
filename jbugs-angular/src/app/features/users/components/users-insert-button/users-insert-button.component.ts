import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-users-insert-button',
  templateUrl: './users-insert-button.component.html',
  styleUrls: ['./users-insert-button.component.css']
})
export class UsersInsertButtonComponent implements OnInit {

  constructor(private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  add(){
    this.router.navigate(['./insert'], {relativeTo: this.route});
  }

}
