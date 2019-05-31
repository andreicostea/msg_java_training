import { Injectable } from '@angular/core';
import { Observable } from "rxjs";

import { BackendService } from "../../../core/backend/backend.service";
import {Bug} from "../models/bugs.model";



@Injectable({
  providedIn: 'root'
})
export class BugsService {


  constructor(private backendService: BackendService) { }

  insertBug(bug : Bug) : Observable<any> {
    return  this.backendService
      .post(`jbugs/jbugs-api/bugs`, bug)

  }


}
