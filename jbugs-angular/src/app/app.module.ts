import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { DashboardComponent } from "./features/dashboard/dashboard.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatNativeDateModule} from "@angular/material";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {LoginModule} from "./features/login/login.module";
import {CookieService} from "ngx-cookie-service";




@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule, MatCheckboxModule,
    LoginModule,
    BrowserAnimationsModule,
    MatNativeDateModule
  ],
  providers: [ CookieService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
