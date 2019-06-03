import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {LoginFormComponent} from './components/login-form/login-form.component';
import {FormsModule} from "@angular/forms";
import {MatButtonModule, MatFormFieldModule, MatInputModule, MatLineModule, MatTabsModule} from "@angular/material";


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
  ]
})
export class LoginModule {
}
