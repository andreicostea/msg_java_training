import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ViewProfileRoutingModule } from './view-profile-routing.module';
import { ViewProfileComponent } from './components/view-profile/view-profile.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import {MatButtonModule, MatInputModule} from "@angular/material";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [ViewProfileComponent, ChangePasswordComponent],
  imports: [
    CommonModule,
    ViewProfileRoutingModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatButtonModule
  ]
})
export class ViewProfileModule { }
