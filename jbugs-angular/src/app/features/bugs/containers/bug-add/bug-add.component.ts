import { Component, OnInit } from '@angular/core';
import {Bug} from "../../models/bugs.model";
import {BugsService} from "../../services/bugs.service";
import {Router} from "@angular/router";
import {FormControl, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material";

export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }
}



@Component({
  selector: 'app-bug-add',
  templateUrl: './bug-add.component.html',
  styleUrls: ['./bug-add.component.css']
})
export class BugAddComponent implements OnInit {

  emailFormControl = new FormControl('', [
    Validators.required,
    // Validators.email,
  ]);

  matcher = new MyErrorStateMatcher();



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
