import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from "./containers/users.component";
import { UsersRoutingModule } from "./users-routing.module";
import { UsersLocallyUsedTestComponentComponent } from './components/users-locally-used-test-component/users-locally-used-test-component.component';

@NgModule({
  declarations: [
    UsersComponent,
    UsersLocallyUsedTestComponentComponent,
  ],
  imports: [
    CommonModule,
    UsersRoutingModule
  ]
})
export class UsersModule { }
