import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './containers/login/login.component';

import { LoginFormComponent } from './components/login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import {MatButtonModule, MatFormFieldModule, MatInputModule, MatLineModule, MatTabsModule} from "@angular/material";
import {MatLabel} from "@angular/material/typings/form-field";
import {MatCardModule} from "@angular/material/typings/esm5/card";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {CookieService} from "ngx-cookie-service";




@NgModule({
  declarations: [LoginFormComponent],
  exports: [
    LoginFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatButtonModule,
    MatTabsModule,
    MatLineModule,
    MatFormFieldModule,
    MatInputModule,

  ],
  providers: [CookieService],
})
export class LoginModule { }
