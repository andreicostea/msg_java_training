import { Component, OnInit } from '@angular/core';
import {Bug} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-bug-add',
  templateUrl: './bug-add.component.html',
  styleUrls: ['./bug-add.component.css']
})
export class BugAddComponent implements OnInit {

 public bug : Bug = new Bug();

  constructor(private bugService : BugsService, private router : Router) { }

  ngOnInit() {
  }

  insert(){
    console.log(this.bug);
    this.bugService.insertBug(this.bug).subscribe((
        value => {console.log(value)}),
      (error => {alert(error.error.message)} ),
      () => {this.router.navigate(['/dashboard'])})
    ;
  }

}
