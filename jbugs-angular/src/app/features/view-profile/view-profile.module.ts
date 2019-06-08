import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ViewProfileRoutingModule } from './view-profile-routing.module';
import { ViewProfileComponent } from './components/view-profile/view-profile.component';

@NgModule({
  declarations: [ViewProfileComponent],
  imports: [
    CommonModule,
    ViewProfileRoutingModule
  ]
})
export class ViewProfileModule { }
