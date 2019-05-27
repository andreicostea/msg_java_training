import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
@Component({
  selector: 'app-permissions',
  templateUrl: './permissions.component.html',
  styleUrls: ['./permissions.component.css']
})
export class PermissionsComponent implements OnInit {
  constructor(private httpClient:HttpClient){
  }

  submitForm(formData):void {
    console.log(formData);
    this.httpClient.post("/jbugs/jbugs-api/permissions", formData).subscribe(
      res=> {
        console.log(res);
      }
    )
  }

  ngOnInit(): void {
  }
}

