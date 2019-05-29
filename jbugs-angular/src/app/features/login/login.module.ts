import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './containers/login/login.component';

import { LoginFormComponent } from './components/login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material";


@NgModule({
  declarations: [LoginFormComponent],
  exports: [
    LoginFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatButtonModule
  ]
})
export class LoginModule { }
