import {Injectable} from '@angular/core';
import {User} from "../../features/users/models/users.model";

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  currentUser: User;
  token: string;

  constructor() {
  }
}
