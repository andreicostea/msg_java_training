import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { DashboardComponent } from "./features/dashboard/dashboard.component";
import {LoginComponent} from "./features/login/containers/login/login.component";
import {LoginModule} from "./features/login/login.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CookieService} from "ngx-cookie-service";
import {AddHeaderInterceptor} from "./core/backend/request.interceptor";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



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
