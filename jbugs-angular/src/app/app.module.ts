import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {MatButtonModule, MatCheckboxModule, MatTableModule} from "@angular/material";
import { DashboardComponent } from "./features/dashboard/dashboard.component";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {LoginModule} from "./features/login/login.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CookieService} from "ngx-cookie-service";
import {AddHeaderInterceptor} from "./core/backend/request.interceptor";

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
    BrowserAnimationsModule,
    MatButtonModule, MatCheckboxModule,
    MatTableModule,
    LoginModule,
    BrowserAnimationsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AddHeaderInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
