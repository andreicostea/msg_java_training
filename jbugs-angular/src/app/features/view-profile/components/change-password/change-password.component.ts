import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material";
import {UsersService} from "../../../users/services/users.service";
import {AuthenticationService} from "../../../../core/services/authentication/authentication.service";
import {UserChangePasswordDTO} from "../../../users/models/users.model";


export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const invalidCtrl = !!(control && control.invalid && control.parent.dirty);
    const invalidParent = !!(control && control.parent && control.parent.invalid && control.parent.dirty);

    return (invalidCtrl || invalidParent);
  }
}

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
  // providers: [UsersService]
})
export class ChangePasswordComponent {

  changePasswordForm: FormGroup;
  matcher = new MyErrorStateMatcher();

  constructor(private formBuilder: FormBuilder, private userService: UsersService, private authService: AuthenticationService) {
    this.changePasswordForm = this.formBuilder.group({
      password: ['', [Validators.required]],
      confirmPassword: ['']
    }, {validator: ChangePasswordComponent.checkPasswords});
  }

  private static checkPasswords(group: FormGroup) { // here we have the 'passwords' group
    let pass = group.controls.password.value;
    let confirmPass = group.controls.confirmPassword.value;

    return pass === confirmPass ? null : { notSame: true }
  }

  onSubmit() {
    let loggedInUsername = this.authService.getUserName();
    let newPassword = this.changePasswordForm.controls.password.value;

    let newPasswordDTO = new UserChangePasswordDTO(loggedInUsername, newPassword);
    this.userService.changePassword(newPasswordDTO).subscribe();
  }
}
