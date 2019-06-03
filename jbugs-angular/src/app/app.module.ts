import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import {MatButtonModule, MatCheckboxModule, MatTableModule} from "@angular/material";
import { DashboardComponent } from "./features/dashboard/dashboard.component";
import {MatButtonModule, MatCheckboxModule, MatNativeDateModule} from "@angular/material";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {LoginModule} from "./features/login/login.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {AddHeaderInterceptor} from "./core/backend/request.interceptor";
import {
  MatDialogModule,
  MatFormFieldModule, MatIconModule,
  MatInputModule,
  MatLineModule, MatMenuModule,
  MatTabsModule, MatToolbarModule
} from "@angular/material";

import {UsersModule} from "./features/users/users.module";
import {BugsModule} from "./features/bugs/bugs.module";
import {UsersUpdateDialogComponent} from "./features/users/components/users-update-dialog/users-update-dialog.component";

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
   LoginComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    MatTableModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    LoginModule,
    BrowserAnimationsModule,
    MatNativeDateModule,
    MatButtonModule,
    MatTabsModule,
    MatLineModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatMenuModule,
    MatIconModule,
    MatToolbarModule,
    UsersModule,
    BugsModule

  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AddHeaderInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
